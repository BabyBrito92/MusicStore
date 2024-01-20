package com.MusicStore.MusicStore.Model.Payment;

import java.util.List;

public interface Payment {

    public String getPaymentType();

    public List<String> getPaymentInfo();
}
