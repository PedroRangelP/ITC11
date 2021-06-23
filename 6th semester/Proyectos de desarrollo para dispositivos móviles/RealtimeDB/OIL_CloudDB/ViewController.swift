//
//  ViewController.swift
//  OIL_CloudDB
//
//  Created by molina on 3/31/19.
//  Copyright © 2019 Tec de Monterrey. All rights reserved.
//

import UIKit
import Firebase

class ViewController: UIViewController {

    @IBOutlet weak var user: UITextField!
    
    @IBOutlet weak var password: UITextField!
    
    @IBAction func registrarUsuario(_ sender: UIButton) {
        
        Auth.auth().createUser(withEmail: user.text!, password: password.text!){(user, error) in
            
            if error != nil{
                print(error!)
            }
            else{
                print("Registro de usuario exitoso")
                self.performSegue(withIdentifier: "goToDetalles", sender: self)
            }
            
        }
    }
    @IBAction func hacerLogin(_ sender: UIButton) {
        
        Auth.auth().signIn(withEmail: user.text!, password: password.text!){
            (user, error) in
            if error != nil{
                print(error!)
                let alert = UIAlertController(title: "Error", message: error.debugDescription, preferredStyle: .alert)
                
                alert.addAction(UIAlertAction(title: "continue", style: .default, handler: nil))
                
                self.present(alert, animated: true)
            }else{
                print("Login exitoso")
                self.performSegue(withIdentifier: "goToDetalles", sender: self)
               
            }
            
        }
        
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }


}

