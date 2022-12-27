function eliminar(id) {

    swal({
        title: "¿Deseas eliminar el usuario?",
        text: "El usuario se eliminara de la lista de manera permanente.",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
            .then((OK) => {
                if (OK) {
                    $.ajax({
                        url:"/eliminar/"+id,
                        success: function(res) {
                            console.log(res);
                        },
                    });
                    swal("El usuario ha sido eliminado", {
                        icon: "success",
                    }).then((ok)=>{
                        if(ok){
                            location.href="/listar";
                        }
                    });
                } else {
                    swal("Se ha cancelado la operacion");
                }
            });
}
