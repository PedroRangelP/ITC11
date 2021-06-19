using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;
using UnityEngine;

[System.Serializable]
public struct Item
{
    public float x, y, z;
    public int id;

    public Item(float x, float y, float z, int id)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
    }
}

public class LevelManager : MonoBehaviour
{
    public MakerItem[] makerItemsPrefabs;
    
    [Header("File must be created in the given path before running the game")]
    public string path = @"C:\GD5\SavedLevel.bin";
    MakerItem[] makerItems;

        //Debug.LogWarning("File must be created in the given path before running the game");
    #warning File must be created in the given path to save correctly
    public void Save()
    {
        makerItems = GameObject.FindObjectsOfType<MakerItem>();
        Item[] items = new Item[makerItems.Length];

        for (int i = 0; i < items.Length; i++)
        {
            items[i] = new Item(makerItems[i].transform.position.x, makerItems[i].transform.position.y, makerItems[i].transform.position.z, makerItems[i].id);
        }

        IFormatter formatter = new BinaryFormatter();
        Stream stream = new FileStream(path, FileMode.Create, FileAccess.Write, FileShare.None);
        formatter.Serialize(stream, items);
        stream.Close();
    }

    public void Load()
    {
        IFormatter formatter = new BinaryFormatter();
        Stream stream = new FileStream(path, FileMode.Open, FileAccess.Read, FileShare.Read);
        var o = (Item[])formatter.Deserialize(stream);
        stream.Close();

        for (int i = 0; i < o.Length; i++)
        {
            Instantiate(makerItemsPrefabs[o[i].id], new Vector3(o[i].x, o[i].y, o[i].z), Quaternion.identity);
        }
    }

    public void Clear()
    {
        makerItems = GameObject.FindObjectsOfType<MakerItem>();
        foreach (var i in makerItems)
        {
            Destroy(i.gameObject);
        }
    }
}
