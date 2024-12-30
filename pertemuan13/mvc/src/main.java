import model.MyBatisUtil;
import model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import view.UserView;
import controller.UserController;
import view.UserPdf;

public class main {
  public static void main(String[] args) {
    SqlSession session = MyBatisUtil.getSqlSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    UserPdf pdf = new UserPdf();

    UserView view = new UserView();
    new UserController(view, mapper, pdf);

    view.setVisible(true);
  }
}
