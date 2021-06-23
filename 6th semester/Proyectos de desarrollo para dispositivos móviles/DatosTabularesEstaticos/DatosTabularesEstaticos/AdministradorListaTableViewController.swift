//
//  AdministradorListaTableViewController.swift
//  DatosTabularesEstaticos
//
//  Created by molina on 15/02/20.
//  Copyright © 2018 Tec de Monterrey. All rights reserved.
//

import UIKit

class AdministradorListaTableViewController: UITableViewController {
    let direccion="http://martinmolina.com.mx/202011/data/datos.json"
    private let datos = [
        "Ford", "BMW", "Audi", "VW", "Chrysler", "Nissan", "Peugeot", "Renault", "Seat", "Citroen"
    ]
    let datosJSON = "[ {\"marca\": \"FORD\", \"agencias\": 21}, {\"marca\": \"BMW\", \"agencias\": 35} ]"
    var nuevoArray:[Any]?
    
    func JSONParseArray(_ string: String) -> [AnyObject]{
        if let data = string.data(using: String.Encoding.utf8){
            
            do{
                
                if let array = try JSONSerialization.jsonObject(with: data, options: JSONSerialization.ReadingOptions.mutableContainers)  as? [AnyObject] {
                    return array
                }
            }catch{
                
                print("error")
                //handle errors here
                
            }
        }
        return [AnyObject]()
    }

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        //nuevoArray = JSONParseArray(datosJSON)
        //let url = URL(string: self.direccion)!
        if let url = URL(string: direccion) {
            do {
                //let contents = try String(contentsOf: url)
                //print(contents)
                let datos = try? Data(contentsOf: url)
                nuevoArray = try! JSONSerialization.jsonObject(with: datos!) as? [Any]
            } catch {
                // contents could not be loaded
                print("contents could not be loaded")
            }
        } else {
            // the URL was bad!
            print("the URL was bad!")
        }
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        
        return nuevoArray!.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        var cell = tableView.dequeueReusableCell(withIdentifier: "zelda", for: indexPath)
        
        
        if (cell == nil) {
            cell = UITableViewCell(
                style: UITableViewCellStyle.default, reuseIdentifier: "zelda")
        }
        let objetoMarca = nuevoArray![indexPath.row] as! [String: Any]
        let s:String = objetoMarca["marca"] as! String
        cell.textLabel?.text=s
        return cell

        // Configure the cell...
    }


    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        let sigVista = segue.destination as! DetalleViewController
        let indice = self.tableView.indexPathForSelectedRow?.row
        let objetoMarca = nuevoArray![indice!] as! [String: Any]
        let s:String = objetoMarca["marca"] as! String

        sigVista.valorRecibido = s
    }
    

}
