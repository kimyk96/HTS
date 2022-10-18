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