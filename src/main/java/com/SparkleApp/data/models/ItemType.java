package com.SparkleApp.data.models;


import lombok.Getter;

@Getter
public enum ItemType {
    JEANS("wash", "iron", "washAndIron"),
    PLAIN_TROUSERS("wash", "iron", "washAndIron"),
    POLO("wash", "iron", "washAndIron"),
    SHORTS("wash", "iron", "washAndIron"),
    HOODIE("wash", "iron", "washAndIron"),
    DUVET("wash", "iron", "washAndIron"),
    UNDER_WEAR("wash", "iron", "washAndIron"),
    CAP("wash", "iron", "washAndIron"),
    SOCKS("wash", "iron", "washAndIron"),
    SUIT("wash", "iron", "washAndIron"),
    SHIRT("wash", "iron", "washAndIron");

    ItemType(String washOnly, String ironOnly, String washAndIronOnly){

    }







}

