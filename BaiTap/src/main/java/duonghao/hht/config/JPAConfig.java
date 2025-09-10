package duonghao.hht.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig {
	private static EntityManagerFactory emf;
	static {
		try {
			emf = Persistence.createEntityManagerFactory("dataSource");
			System.out.println("EntityManagerFactory tạo thành công: " + emf);
		} catch (Exception e) {
			System.err.println("Lỗi tạo EntityManagerFactory. Kiểm tra persistence.xml và driver DB.");
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
//public class JPAConfig {
//    private static EntityManagerFactory emf;
//
//    static {
//        try {
//            emf = Persistence.createEntityManagerFactory("dataSource");
//            if(emf == null) {
//                System.err.println("EntityManagerFactory null! Check persistence.xml");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static EntityManager getEntityManager() {
//        if (emf == null) {
//            throw new IllegalStateException("EntityManagerFactory chưa được khởi tạo!");
//        }
//        return emf.createEntityManager();
//    }
//}
