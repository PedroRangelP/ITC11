using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnerController : MonoBehaviour {
    public GameObject meteor, enemy;
    
    void Start() {
        InvokeRepeating("SpawnMeteor", 2f, 10f);
        InvokeRepeating("SpawnEnemy", 0f, 4f);
    }

    void SpawnMeteor() {
        Vector3 meteorPos = gameObject.transform.position;
        meteorPos.x = Random.Range(-18.53f, 18.53f);
        Instantiate(meteor, meteorPos, Quaternion.identity);
    }

    void SpawnEnemy() {
        Vector3 enemyPos = gameObject.transform.position;
        enemyPos.x = Random.Range(-18.53f, 18.53f);
        Instantiate(enemy, enemyPos, Quaternion.identity);
    }

}
