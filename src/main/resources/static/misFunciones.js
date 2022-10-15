function traerDatosOrtopedic(){
    $.ajax({
        url: 'http://localhost:8090',
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            pintarDatosGeneral(respuesta.items, "name", "ortopedic");
        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });
}

function traerDatosClientes(){
    $.ajax({
        url: 'http://localhost:8090',
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            pintarDatosGeneral(respuesta.items, "name", "client");
        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });
}

function traerDatosMensajes(){
    $.ajax({
        url: 'http://localhost:8090',
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            pintarDatosGeneral(respuesta.items, "messagetext", "message");
        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });
}

function guardarOrtopedic(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'brand': $("#brand").val(),
        'model': $("#model").val(),
        'name': $("#name").val(),
        'category_id': $("#category_id").val(),
    };

    $.ajax({
        url: 'http://localhost:8090',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido agregado con exito");
            traerDatosOrtopedic();

        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });
}


function guardarIdyTipo(id, tipo){
    sessionStorage.setItem.setItem('id', id);
    sessionStorage.setItem.setItem('tipo', tipo);
    location.href='detalle.html';
}

function mostrarDetalle(){
    let id = sessionStorage.getItem('id');
    let tipo = sessionStorage.getItem('tipo');

    $.ajax({
        url: 'http://localhost:8090/'+tipo+'/'+tipo+'/'+id,
        type: 'GET',
        dataType: 'json',
        success: function(respuesta){
            pintarDatosDetalle(respuesta.items);
            pintarEntradasDetalle(respuesta.items);
        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });
}

function pintarDatosGeneral(datos, titulo, tipoTabla){
    let htmlParaInsertar ="";
    htmlParaInsertar+="<tr>";
    htmlParaInsertar+="<th>Titulo</th>"
    htmlParaInsertar+="</tr>";


    for(let i=0;i<datos.length;i++){
        htmlParaInsertar+="<tr>";
        htmlParaInsertar+="<td><a href='#' onclick='guardarIdyTipo("+datos[i].id+", \""+tipoTabla+"\");'>"+datos[i][titulo]+"</a></td>";
        htmlParaInsertar+="</tr>";
    }

    $("#resultado").empty();
    $("#resultado").append(htmlParaInsertar);
}

function pintarDatosDetalle(datos){
    let htmlParaInsertar ="";
    htmlParaInsertar+="<tr>";
    Object.keys(datos[0]).forEach(elemento => htmlParaInsertar+="<th>"+elemento+"</th>");
    htmlParaInsertar+="</tr>";

    for(let i=0; i<datos.length; i++){
        htmlParaInsertar+="<tr>";
        Object.values(datos[i]).forEach(elemento => htmlParaInsertar+="<td>"+elemento+"</td>");
        htmlParaInsertar+="</tr>";
    }

    $("#resultado").empty();
    $("#resultado").append(htmlParaInsertar);
}

function pintarEntradasDetalle(datos){
    let htmlParaInsertar ="";
    Object.keys(datos[0]).forEach(elemento => htmlParaInsertar+="<input id='"+elemento+"' placeholder='"+elemento+"'><br><br>");
    $("#resultado").empty();
    $("#resultado").append(htmlParaInsertar);
}

function actualizarDetalles(){
    let tipo = sessionStorage.getItem('tipo');

    if(tipo=="ortopedic"){
        actualizarOrtopedic();
    } else if(tipo=="message"){
        actualizarMensaje();
    } else if(tipo=="client"){
        actualizarCliente();
    }
}

function actualizarOrtopedic(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'brand': $("#brand").val(),
        'model': $("#model").val(),
        'name': $("#name").val(),
        'category_id': $("#category_id").val()
    };

    $.ajax({
        url: 'http://localhost:8090',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido agregado con exito");
            mostrarDetalle();
        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });
}

function actualizarMensaje(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'messagetext': $("#messagetext").val(),
    };

    $.ajax({
        url: 'http://localhost:8090',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido agregado con exito");
            mostrarDetalle();
        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });
}

function actualizarCliente(){
    let datosPorMandar = {
        'id': $("#id").val(),
        'name': $("#name").val(),
        'email': $("#emaill").val(),
        'name': $("#name").val(),
        'age': $("age").val()

    };
    $.ajax({
        url: 'http://localhost:8090',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El producto ha sido agregado con exito");
            mostrarDetalle();
        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });


}

function borrarDetalle(){
    let id = sessionStorage.getItem('id');
    let tipo = sessionStorage.getItem('tipo');
    let datosPorMandar = {
        'id': id
    }

    $.ajax({
        url: 'http://localhost:8090'+tipo+'/'+tipo,
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify(datosPorMandar),
        success: function(respuesta){
            alert("El elemento ha sido eliminado");
            location.href='homePage.html';
        },
        error: function(respuesta, xhr){
            alert("Error de la peticion");
        }
    });
}