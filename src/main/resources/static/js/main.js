$(function(){
    $("main").css("opacity", "1");
    /* 상단 메뉴 */
    $("#header_goback").click(function(){history.back();});
    /* 하단 메뉴 */
    $("#nav_product").click(function(){ $(location).attr("href", "/product"); });
    $("#nav_board").click(function(){ $(location).attr("href", "/board"); });
    $("#nav_chat").click(function(){ $(location).attr("href", "/chat"); });
    $("#nav_member").click(function(){ $(location).attr("href", "/member"); });

})

// 상품 저장
function savePdt(){
    let fd = new FormData();
    fd.append("pdtCateNo", $("#cate").find(':selected').val());
//    fd.append("pdtAddressNo", $("#address").find(':selected').val());
    fd.append("pdtName", $("#title").val());
    fd.append("pdtDesc", $("#desc").val());
    fd.append("pdtPrice", $("#price").val());

    if($("#images")[0].files.length==0){
        Swal.fire({
            icon: 'error',
            text: '대표 이미지는 필수입니다.'
        })
        return
    }
    if(!$("#cate").find(':selected').val()){
        Swal.fire({
            icon: 'error',
            text: '카테고리를 선택해 주세요'
        })
        return
    }
    if(! $("#title").val()){
        Swal.fire({
            icon: 'error',
            text: '제목을 입력해 주세요'
        })
        return
    }
    if(! $("#desc").val()){
        Swal.fire({
            icon: 'error',
            text: '본문을 입력해 주세요'
        })
        return
    }
    if(! $("#price").val()){
        Swal.fire({
            icon: 'error',
            text: '가격을 입력해 주세요'
        })
        return
    }



    for(let file of $("#images")[0].files){
        fd.append("images", file);
    }
    // 상품 저장
    $.ajax({
        method: "POST",
        url: "/api/v1/pdt/save",
        data: fd,
        contentType: false,
        processData: false,
    }).done((res) => {
        $(location).attr("href", "/product");
    }).fail((res)=>{
        Swal.fire({
            icon: 'error',
            text: res.responseText
        })
    });
}

// 상품 수정
function updatePdt(){
    let pdtNo = new URL(location.href).searchParams.get("pdtNo")
    let fd = new FormData();

    fd.append("pdtCateNo", $("#cate").find(':selected').val());
//    fd.append("pdtAddressNo", $("#address").find(':selected').val());
    fd.append("pdtName", $("#title").val());
    fd.append("pdtDesc", $("#desc").val());
    fd.append("pdtPrice", $("#price").val());
    fd.append("pdtNo", pdtNo);

    for(file of $("#images")[0].files){
        fd.append("images", file);
    }

    if(!$("#cate").find(':selected').val()){
        Swal.fire({
            icon: 'error',
            text: '카테고리를 선택해 주세요'
        })
        return
    }
    if(! $("#title").val()){
        Swal.fire({
            icon: 'error',
            text: '제목을 입력해 주세요'
        })
        return
    }
    if(! $("#desc").val()){
        Swal.fire({
            icon: 'error',
            text: '본문을 입력해 주세요'
        })
        return
    }
    if(! $("#price").val()){
        Swal.fire({
            icon: 'error',
            text: '가격을 입력해 주세요'
        })
        return
    }

    // 상품 수정
    $.ajax({
        method: "PUT",
        url: "/api/v1/pdt/update",
        data: fd,
        contentType: false,
        processData: false,
    }).done((res)=>{
        $(location).attr("href", "/product/" + pdtNo);
    }).fail((res)=>{
        Swal.fire({
            icon: 'error',
            text: res.responseText
        })
    });
}

// 상품 목록 검색
function searchPdtList(addressSi, addressGu, addressDong, keyword, pdtCateNo, start, end){
    if(keyword==""){ return; }
    if(start==1){ $("#search_list").empty(); }

    // 상품 목록 검색
    $.ajax({
        method: "GET",
        url: "/api/v1/pdt/find-all-by-data",
        data : {addressSi, addressGu, addressDong, keyword, pdtCateNo, start, end}
    })
    .done(function(res){
        let $ul = $("#search_list");
        if(res.length==0){
            $("<p style='text-align : center;padding : 30px 0;'>검색 결과가 없습니다.</p>").appendTo($ul);
            $(".btn_list_more").css("display", "none")
        }
        for( let li of res ){
            $(`
            <li onclick="$(location).attr('href', '/product/' + ${li.pdtNo})">
                <div class="img_wrapper">
                    <img src="${li.imgPath}" alt="product_img">
                </div>
                <div class="info_wrapper">
                    <div class="info">
                        <h3 class="info_title">${li.pdtName}</h3>
                        <p>
                            <span class="info_address">${li.addressSi} ${li.addressGu} ${li.addressDong}</span>
                            <span class="info_created_at">${li.pdtCreatedAt}</span>
                        </p>
                        <p>
                            <span class="info_price">${li.pdtPrice}원</span>
                        </p>
                    </div>
                    <div class="count">
                        <p class="count_chat">
                            <img src="/img/icon/chat.png" alt="chat_count" class="${ li.chatCheck ? 'selected' : '' } img_icon">
                            <span>${li.chatCount}</span>
                        </p>
                        <p class="count_like">
                            <img src="/img/icon/member.png" alt="like_count" class="${ li.favoriteCheck ? 'selected' : 'img_icon' }">
                            <span>${li.favoriteCount}</span>
                        </p>
                    </div>
                </div>
            </li>`)
            .appendTo($ul);
        }
    })
    .fail(function(res){
        Swal.fire({
            icon: 'error',
            text: res.responseText
        });
    })
}


// 게시글 목록 검색
function searchBrdList(addressSi, addressGu, addressDong, keyword, brdCateNo, start, end){
    if(keyword==""){ return; }
    if(start==1){ $("#search_list").empty(); }

    // 게시글 목록 검색
    $.ajax({
        method: "GET",
        url: "/api/v1/brd/find-all-by-data",
        data : {addressSi, addressGu, addressDong, keyword, brdCateNo, start, end}
    })
    .done((res)=>{
        let $ul = $("#search_list");
        if(res.length==0){
            $("<p style='text-align : center;padding : 30px 0;'>검색 결과가 없습니다.</p>").appendTo($ul);
            $(".btn_list_more").css("display", "none")
        }
        for( li of res ){
            $(`<li onclick="$(location).attr('href', '/board/${li.brdNo}')">
                <div class="info_wrapper">
                    <div class="info1">
                        <h3 class="info_title">${li.brdTitle}</h3>
                        <p class="info_desc">
                            ${li.brdContent}
                        </p>
                    </div>
                    ${ li.imgPath!=null ? `<div class="img"><img src="${li.imgPath}" alt="product_img"></div>` : '' }
                    <div class="info2">
                        <span class="info_address"></span>
                        <span class="info_created_at">${timeForToday(li.brdCreatedAt)}</span>
                    </div>
                </div>
                <div class="count_wrapper">
                    <p class="count_like">
                        <img src="/img/icon/like.png" alt="like_count" class="${li.brdLikeCheck ? 'selected' : 'img_icon'}">
                        <span>공감 ${li.brdLikeCount}</span>
                    </p>
                    <p class="count_chat">
                        <img src="/img/icon/comment.png" alt="comment_count" class="${li.cmtCheck ? 'selected' : ''} img_icon">
                        <span>댓글 ${li.cmtCount}</span>
                    </p>
                </div>
            </li>`)
            .appendTo($ul);
        }
    })
    .fail((res)=>{
        Swal.fire({
            icon: 'error',
            text: res.responseText
        });
    })
}

// 게시글 저장
function saveBrd(){
    let fd = new FormData();

//    fd.append("pdtAddressNo", $("#address").find(':selected').val());
    fd.append("brdTitle", $("#title").val());
    fd.append("brdContent", $("#desc").val());

    for(file of $("#images")[0].files){
        fd.append("files", file);
        console.log(file);
    }

    if(! $("#title").val()){
        Swal.fire({
            icon: 'error',
            text: '제목을 입력해 주세요'
        })
        return
    }
    if(! $("#desc").val()){
        Swal.fire({
            icon: 'error',
            text: '본문을 입력해 주세요'
        })
        return
    }
    // 상품 저장
    $.ajax({
        method: "POST",
        url: "/api/v1/brd/save",
        data: fd,
        contentType: false,
        processData: false,
    }).done((res) => {
        $(location).attr("href", "/board");
    }).fail((res)=>{
        Swal.fire({
            icon: 'error',
            text: res.responseText
        })
    });
}

// 게시글 수정
function updateBrd(){
    let brdNo = new URL(location.href).searchParams.get("brdNo")
    let fd = new FormData();

    fd.append("brdTitle", $("#title").val());
    fd.append("brdContent", $("#desc").val());
    fd.append("brdNo", brdNo);

    for(file of $("#images")[0].files){
        fd.append("images", file);
    }

    if(! $("#title").val()){
        Swal.fire({
            icon: 'error',
            text: '제목을 입력해 주세요'
        })
        return
    }
    if(! $("#desc").val()){
        Swal.fire({
            icon: 'error',
            text: '본문을 입력해 주세요'
        })
        return
    }

    // 상품 수정
    $.ajax({
        method: "PUT",
        url: "/api/v1/brd/update",
        data: fd,
        contentType: false,
        processData: false,
    }).done((res)=>{
        $(location).attr("href", "/board/" + brdNo);
    }).fail((res)=>{
        Swal.fire({
            icon: 'error',
            text: res.responseText
        })
    });
}














/////////// 공용 함수


// 3자리 마다 반점
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// 시간 포맷
function timeForToday(value) {
        const today = new Date();
        const timeValue = new Date(value);

        const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
        if (betweenTime < 1) return '방금전';
        if (betweenTime < 60) {
            return `${betweenTime}분전`;
        }

        const betweenTimeHour = Math.floor(betweenTime / 60);
        if (betweenTimeHour < 24) {
            return `${betweenTimeHour}시간전`;
        }

        const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
        if (betweenTimeDay < 365) {
            return `${betweenTimeDay}일전`;
        }

        return `${Math.floor(betweenTimeDay / 365)}년전`;
 }

// base64 -> File
function dataURLtoFile(dataurl, fileName){
     let arr = dataurl.split(','),
         mime = arr[0].match(/:(.*?);/)[1],
         bstr = atob(arr[1]),
         n = bstr.length,
         u8arr = new Uint8Array(n);
     while(n--){
         u8arr[n] = bstr.charCodeAt(n);
     }
     return new File([u8arr], fileName, {type:mime});
 }