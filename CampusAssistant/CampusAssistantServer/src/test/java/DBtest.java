import org.junit.Test;
import tools.DBUtils;

import java.sql.SQLException;

public class DBtest {
  /**
   * DB Query Test
   */
  @Test
  public void Dbtest() {
    try {
      DBUtils.query("SELECT SYSDATE() FROM DUAL;");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
