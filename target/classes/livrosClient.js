$(function() {
	$(".js-load-books").on('click', function(){
		$.ajax({
				url:"http://localhost:8080/livros",
				type: "get",
				headers: {
					"Authorizaton" : "Basic YXJpZWw6czNuaDQ="
				},
				success: function(response) {
					alert(response);
				}
		});
	})
});