package io.nateclark.girlscoutcookieapi.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.nateclark.girlscoutcookieapi.domain.CookieOrder;

@Repository
public class JdbcCookieOrderRepository implements CookieOrderRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcCookieOrderRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Iterable<CookieOrder> findAll() {
        return jdbc.query("SELECT * from cookie_orders", this::mapRowToCookieOrder);
    }

    public CookieOrder findById(Integer id) {
        return jdbc.queryForObject("SELECT id," + "lastName," + "address," + "phoneOrEmail," + "numberDonated,"
                + "numberThanksALot," + "numberSmores," + "numberLemonades," + "numberShortbreads," + "numberThinMints,"
                + "numberPeanutButterPatties," + "numberCaramelDeLites," + "numberPeanutButterSandwich,"
                + "paid FROM cookie_orders WHERE id=?", this::mapRowToCookieOrder, id);
    }

    private CookieOrder mapRowToCookieOrder(ResultSet rs, int rowNum) throws SQLException {
        return new CookieOrder(rs.getInt("id"), rs.getString("lastName"), rs.getString("address"),
                rs.getString("phoneOrEmail"), rs.getInt("numberDonated"), rs.getInt("numberThanksALot"),
                rs.getInt("numberSmores"), rs.getInt("numberLemonades"), rs.getInt("numberShortbreads"),
                rs.getInt("numberThinMints"), rs.getInt("numberPeanutButterPatties"), rs.getInt("numberCaramelDeLites"),
                rs.getInt("numberPeanutButterSandwich"), rs.getBoolean("paid"));
    }

    public CookieOrder save(CookieOrder cookieOrder) {
        return jdbc.queryForObject("INSERT INTO cookie_orders (lastName," + "address," + "phoneOrEmail,"
                + "numberDonated," + "numberThanksALot," + "numberSmores," + "numberLemonades," + "numberShortbreads,"
                + "numberThinMints," + "numberPeanutButterPatties," + "numberCaramelDeLites,"
                + "numberPeanutButterSandwich," + "paid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                + "RETURNING id," + "lastName," + "address," + "phoneOrEmail," + "numberDonated," + "numberThanksALot,"
                + "numberSmores," + "numberLemonades," + "numberShortbreads," + "numberThinMints,"
                + "numberPeanutButterPatties," + "numberCaramelDeLites," + "numberPeanutButterSandwich," + "paid",
                this::mapRowToCookieOrder, cookieOrder.lastName, cookieOrder.address, cookieOrder.phoneOrEmail,
                cookieOrder.numberDonated, cookieOrder.numberThanksALot, cookieOrder.numberSmores,
                cookieOrder.numberLemonades, cookieOrder.numberShortbreads, cookieOrder.numberThinMints,
                cookieOrder.numberPeanutButterPatties, cookieOrder.numberCaramelDeLites,
                cookieOrder.numberPeanutButterSandwich, cookieOrder.paid);
    }
}