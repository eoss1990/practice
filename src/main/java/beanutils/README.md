ResultSetDynaClass可以wraps ResultSet <br/>

RowSetDynaClass 可以wraps ResultSet <br/>

LazyDynaBean可以set [simple property] [Map] [数组]，但经过测试HashMap的性能要远高于LazyDynaBean <br/>

BeanComparator 可以通过setProperty添加需要比较的字段，然后自动比较两个Bean