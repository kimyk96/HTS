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

// 회원 추가 정보 기입
function signup(){
    let memUsername = $("#phone").val();
    let memNickname = $("#nickname").val();
    let memEmail = $("#email").val();

    $.ajax({
        method: "PATCH",
        url: "/api/v1/mem/update-by-mem-username",
        data: { memUsername: memUsername, memNickname: memNickname, memEmail: memEmail }
    })
    .done(function(res){
        $(location).attr("href", "/product");
    })
    .fail(function(res){
        Swal.fire({
            icon: 'error',
            text: '정보 등록에 실패하였습니다.'
        })
    })
}
