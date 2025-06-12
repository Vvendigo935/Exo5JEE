package org.example.exo5.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo5.DAO.BaseDAO;
import org.example.exo5.DAO.DogDAO;
import org.example.exo5.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dogServlet", value = "/show")
public class DogServlet extends HttpServlet {

    private List<Dog> dogs;


    protected Session session;
    private SessionFactory sessionFactory;
 //   private BaseDAO baseDAO;
    private DogDAO dogDAO;



    @Override
    public void init() throws ServletException {
        dogs = new ArrayList<>();
        dogDAO = new DogDAO();
        //  dogs.add(new Dog("rex","malinois", LocalDate.now()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("dogs",dogs);
        req.getRequestDispatcher("/WEB-INF/showDog.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recup


        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));

        // creation d'un clébard

        Dog dog = new Dog(name,breed,dateOfBirth);
        dogDAO.save(dog);


        // ajout du clebard a la liste

        this.dogs.add(dog);
        doGet(req,resp);


    }
}

//session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.persist(new Person("toto"));
//        session.getTransaction().commit();
//        session.close();
//        response.setContentType("text/html");