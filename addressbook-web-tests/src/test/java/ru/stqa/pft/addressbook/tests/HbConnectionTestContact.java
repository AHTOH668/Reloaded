package ru.stqa.pft.addressbook.tests;

/*public class HbConnectionTestContact {


    private SessionFactory sessionFactory;

    @BeforeClass
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Test
    public void testHbConnection() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<addressData> result = session.createQuery("from addressData where deprecated = '0000-00-00'").list();
        for (addressData contact : result) {
            System.out.println(contact);
            System.out.println(contact.getGroups());
        }
        session.getTransaction().commit();
        session.close();
    }
}*/
