package com.sbd12.sewamobil.Pkg_ProdusenMobil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ArieDZ_2
 */
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Repository
@Service
public class ProdusenMobilJDBCTemplate implements ProdusenMobilDAO {

   @Autowired private DataSource dataSource;
   @Autowired private JdbcTemplate jdbcTemplateObject;


   /**Note
    * @Autowired berguna untuk Depedency Injection pada Spring
    * @param dataSource
    */
   @Autowired
   @Override
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }
   @Override
   public void create(String id_produsen, Integer nama_produsen) {
      String SQL = "insert into tbl_produsen_mobil (id_produsen_mobil, nama_produsen) values (?, ?)";
      
      jdbcTemplateObject.update( SQL, id_produsen, nama_produsen);
      System.out.println("Created Record Name = " + id_produsen + " Age = " + nama_produsen);
      return;
   }
   @Override
   public List<ProdusenMobil> listSemua() {
      String SQL = "select * from tbl_produsen_mobil";
      List <ProdusenMobil> produsens = jdbcTemplateObject.query(SQL, new ProdusenMobilMapper());
      return produsens;
   }

   @Override
    public ProdusenMobil getId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
