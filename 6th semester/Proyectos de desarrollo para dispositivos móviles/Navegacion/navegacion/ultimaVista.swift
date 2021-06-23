//
//  ultimaVista.swift
//  navegacion
//
//  Created by molina on 24/04/21.
//

import UIKit

class ultimaVista: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func logout(_ sender: UIButton) {
        view.window?.rootViewController?.dismiss(animated: true, completion: nil) //hasta la raiz
    }
    
    @IBAction func atras(_ sender: Any) {
        self.presentingViewController?.dismiss(animated: true, completion: nil) //uno atras
       
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
