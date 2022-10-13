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

