//
//  DetalleViewController.swift
//  DatosTabularesEstaticos
//
//  Created by molina on 22/02/18.
//  Copyright © 2018 Tec de Monterrey. All rights reserved.
//

import UIKit

class DetalleViewController: UIViewController {

    @IBOutlet weak var marca: UILabel!
    var valorRecibido = ""
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        marca.text = valorRecibido
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
