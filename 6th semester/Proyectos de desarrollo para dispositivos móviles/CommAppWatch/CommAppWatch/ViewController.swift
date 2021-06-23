//
//  ViewController.swift
//  CommAppWatch
//
//  Created by molina on 05/11/20.
//

import UIKit
import WatchConnectivity

class ViewController: UIViewController, WCSessionDelegate {
    func session(_ session: WCSession, activationDidCompleteWith activationState: WCSessionActivationState, error: Error?) {
        
    }
    
    func sessionDidBecomeInactive(_ session: WCSession) {
        
    }
    
    func sessionDidDeactivate(_ session: WCSession) {
        
    }
    
    @IBOutlet weak var longitud: UITextField!
    var miSesion: WCSession! = nil
    @IBOutlet weak var texto: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        miSesion = WCSession.default
        miSesion.delegate = self
        miSesion.activate()
    }

    @IBAction func enviarReloj(_ sender: UIButton) {
        let latitud = texto.text!
        let longitud = self.longitud.text!
        let mensaje = ["Latitud":latitud,"Longitud":longitud]
        miSesion.sendMessage(mensaje, replyHandler: nil, errorHandler: manejoError(err:))
    }
    func manejoError( err: Error)->Void{
        print(err.localizedDescription)
    }
}

