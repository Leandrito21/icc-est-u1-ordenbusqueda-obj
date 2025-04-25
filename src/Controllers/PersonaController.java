package Controllers;
import Models.Persona;

public class PersonaController {

    public void sortByDireccionCodigo(Persona[] personas){

        //Metedo Ord.Seleccion
        for(int i = 0; i < personas.length; i++ ){
            int indexMayor = i; 
            for(int j = i + 1; j < personas.length; j++){
                //if(personas[j].getCodigoDireccion() > personas[indexMayor].getCodigoDireccion()){
                if(personas[j].compareCodigoDireccion(personas[i])) {
                    indexMayor = j;

                }
            }
            if( i != indexMayor){
                Persona temp = personas[indexMayor];
                personas[indexMayor] = personas[i];
                personas[i] = temp;
            }
        }

    }

    public Persona findPersonByCodigo(Persona[] personas, int codigo){
        int bajo = 0;
        int alto = personas.length - 1;
        while(bajo >= alto){
            int center = (bajo + alto)/2;
            if(personas[center].equalsByCodigoDireccion(codigo) ){
                return personas[center];
            }
           
            if(personas[center].compareCodigoDireccion(codigo)){
                // Sobrecarga de metodos: dos metodos con diferentes parametros
                bajo = center + 1; 

            }else {
                alto = center - 1;
            }
        }
        return null;
    }
    
}
