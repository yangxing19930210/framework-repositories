# TCC Transaction Boot Deploy

## databases
- `doc\db\tcc-boot*.sql`

## properties
- `application.properties`

## jar
- `git clone https://github.com/changmingxie/tcc-transaction.git`
- copied `tcc-transaction\tcc-transaction-server\src\main\config` into tcc-transaction-server from master branch
- tcc-transaction目录执行`mvn install -Dmaven.test.skip=true`来尝试编译一下
- gradle使用maven本地缓存库`mavenLocal()`

## war
Application | Module | HTTP Port | Application Context | Url
----|----|----|----|----
`TccBootCapital` | `tcc-transaction-boot-capital` | 8091 | `/tcc-transaction-boot-capital` | 
`TccBootRedpacket` | `tcc-transaction-boot-redpacket` | 8092 | `/tcc-transaction-boot-redpacket` | 
`TccBootOrder` | `tcc-transaction-boot-order` | 8093 | `/tcc-transaction-boot-order`  | [http://localhost:8093/tcc-transaction-boot-order/](http://localhost:8093/tcc-transaction-boot-order/)

## References
- [tcc-transaction 1.2.x](https://github.com/changmingxie/tcc-transaction/tree/master-1.2.x)
- [使用指南1.2.x](https://github.com/changmingxie/tcc-transaction/wiki/%E4%BD%BF%E7%94%A8%E6%8C%87%E5%8D%971.2.x)