//
//  ViewController.swift
//  ProyectoFinal
//
//  Created by molina on 16/03/21.
//

import UIKit

class ViewController: UIViewController {
    var profesor_enviado = "Sin selección"
    @IBOutlet weak var profesor_desplegado: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        profesor_desplegado.text = profesor_enviado
    }


}

