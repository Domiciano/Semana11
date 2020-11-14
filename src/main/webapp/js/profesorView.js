class ProfesorView{
    constructor(profesor) {
        this.profesor = profesor;
    }

    deleteProfesor = ()=>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState === 4){
               var response = JSON.parse(xhr.responseText);
               if (response.message === 'Operacion exitosa'){
                    if(this.onDeleteFinish !== null) this.onDeleteFinish();
               }else{
                   alert('No se pudo eliminar el profesor');
               }
            }
        });
        xhr.open('DELETE', 'http://localhost:8080/FirstApiRest/api/profesores/delete/'+this.profesor.id);
        xhr.send();
    }

    render = ()=>{
        let component = document.createElement('div');
        component.id = 'profesor'+this.profesor.id;
        component.className = 'profesorComponent';
        let nombre = document.createElement('p');
        let facultad = document.createElement('small');
        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'X';
        delBtn.className = 'delBtn';

        nombre.innerHTML = this.profesor.nombre;
        facultad.innerHTML = this.profesor.facultad;

        component.appendChild(nombre);
        component.appendChild(facultad);
        component.appendChild(delBtn);

        delBtn.addEventListener('click', this.deleteProfesor);
        return component;
    }
}
