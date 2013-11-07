import generator.Generator;
import org.hibernate.Session;
import persistence.HibernateUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 5/11/13
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Generator.generate();
    }
}
