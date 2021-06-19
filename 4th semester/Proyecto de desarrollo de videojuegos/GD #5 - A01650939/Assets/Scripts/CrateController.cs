using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CrateController : MonoBehaviour
{
    [Header("Items to spawn")]
    public GameObject[] items;

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.gameObject.tag == "Player")
        {
            int random = Random.Range(0, items.Length);
            Spawn(random);
            Destroy(gameObject);
        }
    }

    private void Spawn(int random)
    {
        Instantiate(items[random], transform.position, Quaternion.identity);
    }
}
