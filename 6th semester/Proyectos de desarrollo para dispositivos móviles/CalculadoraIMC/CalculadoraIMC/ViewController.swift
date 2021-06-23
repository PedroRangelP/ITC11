//
//  ViewController.swift
//  CalculadoraIMC
//
//  Created by user187947 on 02/03/21.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var peso: UITextField!
    @IBOutlet weak var estatura: UITextField!
    
    @IBAction func toque(_ sender: UITapGestureRecognizer) {
        peso.resignFirstResponder()
        estatura.resignFirstResponder()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        /*let descartar = UITapGestureRecognizer(target: self, action: #selector(UIInputViewController.dismissKeyboard))
        view.addGestureRecognizer(descartar)*/
    }
    
    @objc func dismissKeyboard() {
        view.endEditing(true);
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "irResultados" {
            let sig = segue.destination as! ResultadosViewController
            
            sig.peso = Double(peso.text!)!
            sig.estatura = Double(estatura.text!)!
        }
    }
}

