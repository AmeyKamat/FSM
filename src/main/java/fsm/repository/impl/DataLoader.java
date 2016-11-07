package fsm.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import fsm.entity.Desk;
import fsm.entity.LayoutExtremes;
import fsm.entity.OfficeDetails;
import fsm.entity.TableData;
import fsm.entity.Users;

/**
 * Created by Sarthak on 13-09-2016.
 */
public class DataLoader {
    private SessionFactory factory;
    public DataLoader(){
        try {
            //factory = new Configuration().configure().buildSessionFactory();
            Configuration configuration=new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistryBuilder srb=new ServiceRegistryBuilder().applySettings(configuration.getProperties());
            factory = configuration.buildSessionFactory(srb.getBootstrapServiceRegistry());
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Session factory failed");
        }
    }
    public void saveDesk(List<Desk> desks){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        for(Desk desk:desks){
            session.save(desk);
        }
        transaction.commit();
        session.close();
    }

    public void saveExtremes(LayoutExtremes layoutExtremes) {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(layoutExtremes);
        transaction.commit();
        session.close();
    }
    public void saveUser(Users users){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(users);
        transaction.commit();
        session.close();
    }
    public List<OfficeDetails> getOfficeDetails(){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        List<OfficeDetails> officeDetails=session.createQuery("from OfficeDetails ").list();
        return officeDetails;
    }
    public Users getUser(String id){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        List<Users> usersList=session.createQuery("from Users where id='"+id+"'").list();
        Users user=null;
        if(usersList.size()==0)
            return user;
        user=usersList.get(0);
        return user;
    }
    public void deleteData(String locationId){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Query q=session.createQuery("delete Desk where locationId='"+locationId+"'");
        Query q1=session.createQuery("delete LayoutExtremes where layoutId='"+locationId+"'");
        //Query q=session.createQuery("delete Desk");
        //Query q1=session.createQuery("delete LayoutExtremes");
        Query q2=session.createQuery("delete TableData where layoutId='"+locationId+"'");
        Query q3=session.createQuery("delete OfficeDetails where officeUid="+locationId);
        q.executeUpdate();
        q1.executeUpdate();
        q2.executeUpdate();
        q3.executeUpdate();
        transaction.commit();
        session.close();
    }
    public List<Desk> getDesks(){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        List<Desk> users = session.createQuery("from Desk").list();
        return users;
    }
    public OfficeDetails getOfficeDetails(String country,String city,String branch,String floor){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from OfficeDetails where country=:country and city=:city and branch=:branch and floor=:floor");
        query.setParameter("country",country);
        query.setParameter("city",city);
        query.setParameter("branch",branch);
        query.setParameter("floor",floor);
        List<OfficeDetails> officeDetailsList=query.list();
        OfficeDetails officeDetails=null;
        if(officeDetailsList.size()==0){
            session.close();
            return officeDetails;
        }
        session.close();
        return officeDetailsList.get(0);
    }
    public void saveOfficeDetails(OfficeDetails officeDetails){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(officeDetails);
        transaction.commit();
        session.close();
    }
    public LayoutExtremes getLayoutExtremes(String country,String city,String branch,String floor){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        OfficeDetails officeDetails=getOfficeDetails(country, city, branch, floor);
        LayoutExtremes layoutExtremes=null;
        if(officeDetails==null) {
            session.close();
            return layoutExtremes;
        }
        String officeId=officeDetails.getOfficeUid()+"";
        Query query=session.createQuery("from LayoutExtremes where layoutId=:layoutId");
        query.setParameter("layoutId",officeId);
        List<LayoutExtremes> layoutExtremesList=query.list();
        if(layoutExtremesList.size()==0) {
            session.close();
            return layoutExtremes;
        }
        session.close();
        return layoutExtremesList.get(0);
    }
    public LayoutExtremes getLayoutExtremes(){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        LayoutExtremes layoutExtremes = (LayoutExtremes) session.createQuery("from LayoutExtremes ").list().get(0);
        return layoutExtremes;
    }
    public void saveTableData(List<TableData> tableData){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        for(TableData td:tableData){
            session.save(td);
        }
        transaction.commit();
        session.close();
    }
    public List<TableData> getTableData(String country,String city,String branch,String floor){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        List<TableData> tableData = null;
        OfficeDetails officeDetails=getOfficeDetails(country, city, branch, floor);
        if(officeDetails==null) {
            session.close();
            return tableData;
        }
        String layoutId=officeDetails.getOfficeUid()+"";
        Query query=session.createQuery("from TableData where layoutId=:layoutId");
        query.setParameter("layoutId",layoutId);
        tableData = query.list();
        session.close();
        return tableData;
    }
    public List<TableData> getTableData(){
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        List<TableData>  tableDatas = session.createQuery("from TableData").list();
        return tableDatas;
    }
}
