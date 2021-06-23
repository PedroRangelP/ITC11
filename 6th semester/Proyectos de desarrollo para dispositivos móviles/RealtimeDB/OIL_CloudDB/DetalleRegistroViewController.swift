//
//  DetalleRegistroViewController.swift
//  OIL_CloudDB
//
//  Created by molina on 3/31/19.
//  Copyright © 2019 Tec de Monterrey. All rights reserved.
//

import UIKit
import Firebase
import FirebaseDatabase

class DetalleRegistroViewController: UIViewController {

    @IBOutlet weak var nombre: UITextField!
    @IBOutlet weak var equipo: UITextField!
    
    //Definición de referencia a la BD
    let ref = Database.database().reference()
    
    override func viewDidLoad() {
        super.viewDidLoad()


        // Do any additional setup after loading the view.
    }
    
    @IBAction func guardarDatos(_ sender: UIButton) {
        //Para la identificación del path se utilizará el User Id del usuario actual
        let userid = Auth.auth().currentUser?.uid
        //Obtener el texto introducido por el usuario
        //Hace falta verificar que el texto no sea nulo
        let n:String = self.nombre.text!
        let e:String = self.equipo.text!
       //Relizar la actualización en la BD
        ref.child("Usuarios/"+userid!).updateChildValues(["Equipo":e, "Nombre":n])
        //Notificar al usuario que la actualización fue exitosa
        let alert = UIAlertController(title: "Guardar", message: "Los datos se almacenaron exitosamente", preferredStyle: .alert)
        
        alert.addAction(UIAlertAction(title: "continue", style: .default, handler: nil))
        
        self.present(alert, animated: true)
        
    }
    
    @IBAction func cargarDatos(_ sender: UIButton) {
        /*lectura*/
        
        //Para la identificación del path se utilizará el User Id del usuario actual
         let userid = Auth.auth().currentUser?.uid
        // El método .observeSingleEvent realiza una consulta puntual de los valores de los atributos hijos del path
        ref.child("Usuarios").child(userid!).observeSingleEvent(of: .value){
         (snapshot) in
         let datos = snapshot.value as? [String:Any]
         
         self.nombre.text = datos?["Nombre"] as! String
         self.equipo.text = datos?["Equipo"] as! String
         }
 
    }
    
     @IBAction func logout(_ sender: UIButton) {
        do{
            //Método para cirre de sesión
            try Auth.auth().signOut()
            //Regresa a la vista raíz del navegador
            navigationController?.popToRootViewController(animated: true)
            
        }catch{
            print("Error en logout")
            let alert = UIAlertController(title: "Error", message: "Error en Logout", preferredStyle: .alert)
            
            alert.addAction(UIAlertAction(title: "continue", style: .default, handler: nil))
            
            self.present(alert, animated: true)
        }
     }
    /*
     // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
