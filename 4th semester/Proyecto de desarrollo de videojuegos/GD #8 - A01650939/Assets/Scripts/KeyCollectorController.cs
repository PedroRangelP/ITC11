using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class KeyCollectorController : MonoBehaviour
{
    private int collectedKeys;

    public int getCollectedKeys()
    {
        return collectedKeys;
    }
    private void OnCollisionEnter(Collision other)
    {
        if (other.gameObject.tag == "Key")
        {
            collectedKeys +=1;
            Debug.Log("Keys: "+collectedKeys);
            Destroy(other.gameObject);
        }
    }    
}
