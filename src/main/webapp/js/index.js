//Declaraciones
const nombre = document.getElementById('nombre');
const facultad = document.getElementById('facultad');
const regBtn = document.getElementById('regBtn');
const profesoresContainer = document.getElementById('profesoresContainer');

const registrar = ()=>{
    let profeObj = {
        id: 0,
        nombre: nombre.value,
        facultad: facultad.value
    };
    //POST
    let xhr = new XMLHttpRequest();
    //Response
    xhr.addEventListener('readystatechange', ()=>{
       console.log(xhr.responseText);
       getAllProfesores();
    });
    xhr.open('POST', 'http://localhost:8080/FirstApiRest/api/profesores/create');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(profeObj));
};

regBtn.addEventListener('click', registrar);

const getAllProfesores = ()=>{
    console.log('GET all profesores');
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
       if(xhr.readyState === 4){
           let json = xhr.responseText;
           let response = JSON.parse(json);
           console.log(response);

           profesoresContainer.innerHTML = '';
           for(let i=0 ; i<response.length ; i++){
               let profesorDTO = response[i];
               let view = new ProfesorView(profesorDTO);
               view.onDeleteFinish = ()=>{
                   profesoresContainer.removeChild(document.getElementById('profesor'+profesorDTO.id))
               };
               profesoresContainer.appendChild(view.render());
           }
       }
    });
    xhr.open('GET', 'http://localhost:8080/FirstApiRest/api/profesores/all');
    xhr.send();
}
getAllProfesores();
