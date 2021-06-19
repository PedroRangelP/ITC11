using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class HealthController : MonoBehaviour {
    private Transform bar;

    private void Start() {
        bar =  transform.Find("Bar");
    }

    public void SetSize(float size) {
        bar.localScale = new Vector3(size,1f,1f);
    }
}
