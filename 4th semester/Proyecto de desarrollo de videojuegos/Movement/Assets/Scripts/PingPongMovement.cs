using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PingPongMovement : MonoBehaviour
{
    public Transform ping, pong;
    public float speed;
    private Vector3 currentTarget, _ping, _pong;

    private void Start()
    {
        currentTarget = ping.position;
        _ping = ping.position;
        _pong = pong.position;
    }

    private void Update()
    {
        Move();
    }

    private void Move()
    {
        float distance = Vector3.Distance(transform.position, currentTarget);
        if (distance <= 0)
        {
            if (currentTarget == _ping)
            {
                currentTarget = _pong;
            }
            else
            {
                currentTarget = _ping;
            }
        }
        else
        {
            transform.position  = Vector3.Lerp(transform.position, currentTarget, (Time.deltaTime * speed) / distance);
        }
    }
}
