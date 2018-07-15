package controllers;

import db.DBHelper;
import models.Customer;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class CustomerController {

    public CustomerController() {this.setupEndPoints();}

        private void setupEndPoints(){

        get("/customers", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("template", "templates/customers/index.vtl");
            model.put("customers", customers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
        }
}
