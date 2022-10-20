// 화면 로딩 후
$(function(){
    /* 상단 메뉴 */
    // 뒤로가기
    $("#header_goback").click(function(){history.back();});
    /* 하단 메뉴 */
    // 상품
    $("#nav_product").click(function(){ $(location).attr("href", "/product"); });
    // 게시판
    $("#nav_board").click(function(){ $(location).attr("href", "/board"); });
    // 채팅
    $("#nav_chat").click(function(){ $(location).attr("href", "/chat"); });
    // 회원
    $("#nav_member").click(function(){ $(location).attr("href", "/member"); });
})

// 상품 저장
function savePdt(){
    let fd = new FormData();
    fd.append("pdtCateNo", $("#cate").find(':selected').val());
    fd.append("pdtAddressNo", $("#address").find(':selected').val());
    fd.append("pdtName", $("#title").val());
    fd.append("pdtDesc", $("#desc").val());
    fd.append("pdtPrice", $("#price").val());
    for(file of $("#images")[0].files){
        fd.append("images", file);
        console.log(file);
    }

    $.ajax({
        method: "POST",
        url: "/api/v1/pdt/save",
        data: fd,
        contentType: false,
        processData: false,
    }).done((res) => {
        if(res==1){
            $(location).attr("href", "/product");
        }else{
            Swal.fire({
                icon: 'error',
                text: res
            })
        }
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
    fd.append("pdtAddressNo", $("#address").find(':selected').val());
    fd.append("pdtName", $("#title").val());
    fd.append("pdtDesc", $("#desc").val());
    fd.append("pdtPrice", $("#price").val());
    fd.append("pdtNo", pdtNo);
    for(file of $("#images")[0].files){
        fd.append("images", file);
        console.log(file);
    }

    $.ajax({
        method: "PUT",
        url: "/api/v1/pdt/update",
        data: fd,
        contentType: false,
        processData: false,
    }).done((res) => {
        if(res==1){
            $(location).attr("href", "/product/" + pdtNo);
        }else{
            Swal.fire({
                icon: 'error',
                text: res
            })
        }
    }).fail((res)=>{
        Swal.fire({
            icon: 'error',
            text: res.responseText
        })
    });
}

// 상품 목록 검색
async function searchPdtList(addressSi, addressGu, addressDong, keyword, pdtCateNo, start, end){
    if(keyword==""){
        return;
    }
    if(start==1){
        $("#search_list").empty();
    }

    await $.ajax({
        method: "GET",
        url: "/api/v1/pdt/find-all-by-data",
        data : {addressSi, addressGu, addressDong, keyword, pdtCateNo, start, end}
    })
    .done(function(res){
        let $ul = $("#search_list");
        if(res.length==0){
            $("<p style='text-align : center;padding : 30px 0;'>검색 결과가 없습니다.</p>").appendTo($ul);
        }
        for( li of res ){
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
                            <img src="/img/icon/chat.png" alt="chat_count" class="${ li.chatCheck ? 'selected' : '' }">
                            <span>${li.chatCount}</span>
                        </p>
                        <p class="count_like">
                            <img src="/img/icon/member.png" alt="like_count" class="${ li.favoriteCheck ? 'selected' : '' }">
                            <span>${li.favoriteCount}</span>
                        </p>
                    </div>
                </div>
            </li>`)
            .appendTo($ul);
        }
    })
    .fail(function(res){})
}



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