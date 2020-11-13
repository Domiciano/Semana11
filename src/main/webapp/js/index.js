const downBtn = document.getElementById('downBtn');


const descargar = ()=>{
    let url = 'http://localhost:8080/FirstApiRest/api/profesores/all';
    let xhr = new XMLHttpRequest();

    //Activar animacion de cargar

    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            //Aqui recibo el response
            console.log(xhr.responseText);
            //Desactivar animacion de cargar
        }
    });

    xhr.open('GET', url);
    xhr.send();
    //Envio de request
}

downBtn.addEventListener('click', descargar);
