//
//  ResultadosViewController.swift
//  CalculadoraIMC
//
//  Created by user187947 on 12/03/21.
//

import UIKit

class ResultadosViewController: UIViewController {

    @IBOutlet weak var foto: UIImageView!
    @IBOutlet weak var resultado: UILabel!
    @IBOutlet weak var clasificacion: UILabel!
    var peso = 0.0
    var estatura = 0.0
    var imc = 0.0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        imc = peso/(estatura*estatura)
        resultado.text = String(format: "%.2f", imc)
        clasificacion.text = clasificarIMC(imc: imc)
    }
    
    func clasificarIMC(imc:Double)->String{
        if(imc<=18.5) {
            resultado.textColor = UIColor(red: 50/255, green: 154/255, blue: 205/255, alpha: 1.0)
            clasificacion.textColor = resultado.textColor
            foto.image = UIImage(named: "imc1")
            return "Bajo de peso"
        }else if(imc>18.5 && imc<25) {
            resultado.textColor = UIColor(red: 51/255, green: 205/255, blue: 205/255, alpha: 1.0)
            clasificacion.textColor = resultado.textColor
            foto.image = UIImage(named: "imc2")
            return "Peso saludable"
        }else if(imc>=25 && imc<30) {
            resultado.textColor = UIColor(red: 152/255, green: 206/255, blue: 50/255, alpha: 1.0)
            clasificacion.textColor = resultado.textColor
            foto.image = UIImage(named: "imc3")
            return "Sobrepeso"
        }else if(imc>=30 && imc<35) {
            resultado.textColor = UIColor(red: 203/255, green: 205/255, blue: 51/255, alpha: 1.0)
            clasificacion.textColor = resultado.textColor
            foto.image = UIImage(named: "imc4")
            return "Obesidad grado 1"
        }else if(imc>=35 && imc<40) {
            resultado.textColor = UIColor(red: 253/255, green: 154/255, blue: 52/255, alpha: 1.0)
            clasificacion.textColor = resultado.textColor
            foto.image = UIImage(named: "imc5")
            return "Obesidad grado 2"
        }else {
            resultado.textColor = UIColor(red: 1.0, green: 103/255, blue: 100/255, alpha: 1.0)
            clasificacion.textColor = resultado.textColor
            foto.image = UIImage(named: "imc5")
            return "Obesidad mórbida"
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
