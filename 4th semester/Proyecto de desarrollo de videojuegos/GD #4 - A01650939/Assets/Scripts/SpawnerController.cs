using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnerController : MonoBehaviour
{
    [SerializeField] private GameObject green, blue, black;

    void Start() {
        InvokeRepeating("SpawnGreen", 0, 2f);
        InvokeRepeating("SpawnBlue", 0, 2.5f);
        InvokeRepeating("SpawnBlack", 0, 3f);
    }

    void SpawnGreen() {
        Vector3 position = new Vector3(11f, -1.5f, 0);
        Instantiate(green, position, Quaternion.Euler(0,0,270));
    }

    void SpawnBlue() {
        Vector3 position = new Vector3(-11f, 0.5f, 0);
        Instantiate(blue, position, Quaternion.Euler(0,0,90));
    }

    void SpawnBlack() {
        Vector3 position = new Vector3(-11f, 2.5f, 0);
        Instantiate(black, position, Quaternion.Euler(0,0,90));
    }
}
