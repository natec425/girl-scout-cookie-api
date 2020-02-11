package io.nateclark.girlscoutcookieapi.domain;

import java.util.Objects;

public class CookieOrder {
    public Integer id;
    public String lastName;
    public String address;
    public String phoneOrEmail;
    public Integer numberDonated = 0;
    public Integer numberThanksALot = 0;
    public Integer numberSmores = 0;
    public Integer numberLemonades = 0;
    public Integer numberShortbreads = 0;
    public Integer numberThinMints = 0;
    public Integer numberPeanutButterPatties = 0;
    public Integer numberCaramelDeLites = 0;
    public Integer numberPeanutButterSandwich = 0;
    public Boolean paid = false;

    public CookieOrder() {
    }

    public CookieOrder(String lastName, String address, String phoneOrEmail) {
        this.lastName = lastName;
        this.address = address;
        this.phoneOrEmail = phoneOrEmail;
    }

    public CookieOrder(Integer id, String lastName, String address, String phoneOrEmail, Integer numberDonated,
            Integer numberThanksALot, Integer numberSmores, Integer numberLemonades, Integer numberShortbreads,
            Integer numberThinMints, Integer numberPeanutButterPatties, Integer numberCaramelDeLites,
            Integer numberPeanutButterSandwich, Boolean paid) {
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.phoneOrEmail = phoneOrEmail;
        this.numberDonated = numberDonated;
        this.numberThanksALot = numberThanksALot;
        this.numberSmores = numberSmores;
        this.numberLemonades = numberLemonades;
        this.numberShortbreads = numberShortbreads;
        this.numberThinMints = numberThinMints;
        this.numberPeanutButterPatties = numberPeanutButterPatties;
        this.numberCaramelDeLites = numberCaramelDeLites;
        this.numberPeanutButterSandwich = numberPeanutButterSandwich;
        this.paid = paid;
    }

    public Integer calculateTotal() {
        return (numberDonated + numberThanksALot + numberSmores + numberLemonades + numberShortbreads + numberThinMints
                + numberPeanutButterPatties + numberCaramelDeLites + numberPeanutButterSandwich) * 5;
    }

    public void update(CookieOrder order) {
        if (!Objects.isNull(order.lastName)) {
            lastName = order.lastName;
        }
        if (!Objects.isNull(order.address)) {
            address = order.address;
        }
        if (!Objects.isNull(order.phoneOrEmail)) {
            phoneOrEmail = order.phoneOrEmail;
        }
        if (!Objects.isNull(order.numberDonated)) {
            numberDonated = order.numberDonated;
        }
        if (!Objects.isNull(order.numberThanksALot)) {
            numberThanksALot = order.numberThanksALot;
        }
        if (!Objects.isNull(order.numberSmores)) {
            numberSmores = order.numberSmores;
        }
        if (!Objects.isNull(order.numberLemonades)) {
            numberLemonades = order.numberLemonades;
        }
        if (!Objects.isNull(order.numberShortbreads)) {
            numberShortbreads = order.numberShortbreads;
        }
        if (!Objects.isNull(order.numberThinMints)) {
            numberThinMints = order.numberThinMints;
        }
        if (!Objects.isNull(order.numberPeanutButterPatties)) {
            numberPeanutButterPatties = order.numberPeanutButterPatties;
        }
        if (!Objects.isNull(order.numberCaramelDeLites)) {
            numberCaramelDeLites = order.numberCaramelDeLites;
        }
        if (!Objects.isNull(order.numberPeanutButterSandwich)) {
            numberPeanutButterSandwich = order.numberPeanutButterSandwich;
        }
        if (!Objects.isNull(order.paid)) {
            paid = order.paid;
        }
    }
}