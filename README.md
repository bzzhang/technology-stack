# technology-stack
MYBATIS 和LOGBACK集成打印SQL:
1、<logger name="org.apache.ibatis" level="DEBUG"/>
<logger name="java.sql.Statement" level="DEBUG"/>
<logger name="java.sql.PreparedStatement" level="DEBUG"/>
 2、保证LOGBACK logging.level.root =DEBUG
