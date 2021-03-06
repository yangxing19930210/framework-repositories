# Big Data

## Contents
### Solr
- [Solr](solr/README.md)

### Storm
- [Storm](storm/README.md)

### Kafka
- [Kafka](kafka/README.md)

### Hadoop
- [Hadoop](hadoop/README.md)
    - [Enviornment Setup](../doc/source/big-data/hadoop/HadoopEnviornmentSetup.md)
    - [HDFS](../doc/source/big-data/hadoop/HadoopHdfs.md)
    - [Command Reference](../doc/source/big-data/hadoop/HadoopCommandReference.md)
    - [MapReduce](../doc/source/big-data/hadoop/HadoopMapReduce.md)
    - [Streaming](../doc/source/big-data/hadoop/HadoopStreaming.md)
    - [Multi-Node Cluster](../doc/source/big-data/hadoop/HadoopMultiNodeCluster.md)
        - [Adding a New DataNode in the Hadoop Cluster](../doc/source/big-data/hadoop/HadoopMultiNodeCluster.md#adding-a-new-datanode-in-the-hadoop-cluster)
        - [Removing a DataNode from the Hadoop Cluster](../doc/source/big-data/hadoop/HadoopMultiNodeCluster.md#removing-a-datanode-from-the-hadoop-cluster)
    - [YARN](../doc/source/big-data/hadoop/HadoopYarn.md)

### HBase
- [HBase](hbase/README.md)
    - [HBase Overview](../doc/source/big-data/hbase/HBaseOverview.md)
    - [HBase Architecture](../doc/source/big-data/hbase/HBaseArchitecture.md)
    - [HBase Installation](../doc/source/big-data/hbase/HBaseInstallation.md)
    - [HBase Shell](../doc/source/big-data/hbase/HBaseShell.md)
    - [HBase Admin API](../doc/source/big-data/hbase/HBaseAdminAPI.md)
    - [HBase Create Table](../doc/source/big-data/hbase/HBaseTable.md)
    - [HBase Listing Table](../doc/source/big-data/hbase/HBaseTable.md#listing-table)
    - [HBase Disabling a Table](../doc/source/big-data/hbase/HBaseTable.md#disabling-a-table)
    - [HBase Enabling a Table](../doc/source/big-data/hbase/HBaseTable.md#enabling-a-table)
    - [HBase Describe & Alter](../doc/source/big-data/hbase/HBaseTable.md#describe--alter)
    - [HBase Exists](../doc/source/big-data/hbase/HBaseTable.md#exists)
    - [HBase Drop a Table](../doc/source/big-data/hbase/HBaseTable.md#drop-a-table)
    - [HBase Shutting Down](../doc/source/big-data/hbase/HBaseAdminAPI.md#shutting-down)
    - [HBase Client API](../doc/source/big-data/hbase/HBaseClientAPI.md)
    - [HBase Create Data](../doc/source/big-data/hbase/HBaseData.md)
    - [HBase Update Data](../doc/source/big-data/hbase/HBaseData.md#update-data)
    - [HBase Read Data](../doc/source/big-data/hbase/HBaseData.md#read-data)
    - [HBase Delete Data](../doc/source/big-data/hbase/HBaseData.md#delete-data)
    - [HBase Scan](../doc/source/big-data/hbase/HBaseData.md#scan)
    - [HBase Count & Truncate](../doc/source/big-data/hbase/HBaseData.md#count--truncate)
    - [HBase Security](../doc/source/big-data/hbase/HBaseData.md#security)

### Hive
- [Hive](hive/README.md)
    - [Hive Introduction](../doc/source/big-data/hive/HiveIntroduction.md)
    - [Hive Installation](../doc/source/big-data/hive/HiveInstallation.md)
    - [Hive Data Types](../doc/source/big-data/hive/HiveDataTypes.md)
    - [Hive Create Database](../doc/source/big-data/hive/HiveDatabase.md)
    - [Hive Drop Database](../doc/source/big-data/hive/HiveDatabase.md#drop-database)
    - [Hive Create Table](../doc/source/big-data/hive/HiveTable.md)
    - [Hive Alter Table](../doc/source/big-data/hive/HiveTable.md#alter-table)
    - [Hive Drop Table](../doc/source/big-data/hive/HiveTable.md#drop-table)
    - [Hive Partitioning](../doc/source/big-data/hive/HivePartitioning.md)
    - [Hive Built-in Operators](../doc/source/big-data/hive/HiveBuiltInOperators.md)
    - [Hive Built-in Functions](../doc/source/big-data/hive/HiveBuiltInFunctions.md)
    - [Hive View and Indexes](../doc/source/big-data/hive/HiveViewIndexes.md)
    - [HiveQL](../doc/source/big-data/hive/HiveQL.md)
        - [HiveQL Select-Where](../doc/source/big-data/hive/HiveQL.md#select-where)
        - [HiveQL Select-Order By](../doc/source/big-data/hive/HiveQL.md#select-order-by)
        - [HiveQL Select-Group By](../doc/source/big-data/hive/HiveQL.md#select-group-by)
        - [HiveQL Select-Joins](../doc/source/big-data/hive/HiveQL.md#select-joins)
    - [Hive vs. HBase](../doc/source/big-data/hive/HiveHBase.md)

### Spark SQL
- [Spark SQL](spark/README.md)
    - [Spark Introduction](../doc/source/big-data/spark/SparkIntroduction.md)
    - [Spark RDD](../doc/source/big-data/spark/SparkRDD.md)
    - [Spark Installation](../doc/source/big-data/spark/SparkInstallation.md)
    - [Spark SQL Introduction](../doc/source/big-data/spark/SparkSqlIntroduction.md)
    - [Spark SQL DataFrames](../doc/source/big-data/spark/SparkSqlDataFrames.md)
        - [Inferring the Schema using Reflection](../doc/source/big-data/spark/SparkSqlDataFrames.md#inferring-the-schema-using-reflection)
        - [Programmatically Specifying the Schema](../doc/source/big-data/spark/SparkSqlDataFrames.md#programmatically-specifying-the-schema)
    - [Spark SQL Data Sources](../doc/source/big-data/spark/SparkSqlDataSources.md)
        - [Spark SQL JSON Datasets](../doc/source/big-data/spark/SparkSqlDataSources.md)
        - [Spark SQL Hive Tables](../doc/source/big-data/spark/SparkSqlDataSources.md#spark-sql-hive-tables)
        - [Spark SQL Parquet Files](../doc/source/big-data/spark/SparkSqlDataSources.md#spark-sql-parquet-files)

### Flume
- [Flume](flume/README.md)
    - [Flume Introduction](../doc/source/big-data/flume/FlumeIntroduction.md)
    - [Flume Architecture](../doc/source/big-data/flume/FlumeIntroduction.md#architecture)
    - [Flume Data Flow](../doc/source/big-data/flume/FlumeIntroduction.md#data-flow)
    - [Flume Environment](../doc/source/big-data/flume/FlumeEnvironment.md)
    - [Flume Configuration](../doc/source/big-data/flume/FlumeConfiguration.md)
    - [Flume Sequence Generator Source](../doc/source/big-data/flume/FlumeSequenceGeneratorSource.md)
    - [Flume NetCat Source](../doc/source/big-data/flume/FlumeNetCatSource.md)

### Pig
- [Pig](pig/README.md)
    - [Pig Introduction](../doc/source/big-data/pig/PigOverview.md)
        - [Pig Overview](../doc/source/big-data/pig/PigOverview.md)
        - [Pig Architecture](../doc/source/big-data/pig/PigArchitecture.md)
    - [Pig Environment](../doc/source/big-data/pig/PigInstallation.md)
        - [Pig Installation](../doc/source/big-data/pig/PigInstallation.md)
        - [Pig Execution](../doc/source/big-data/pig/PigExecution.md)
        - [Pig Grunt Shell](../doc/source/big-data/pig/PigGruntShell.md)
    - [Pig Latin](../doc/source/big-data/pig/PigLatinBasics.md)
        - [Pig Latin Basics](../doc/source/big-data/pig/PigLatinBasics.md)
    - [Load & Store Operators](../doc/source/big-data/pig/PigLoadStoreOperators.md)
        - [Pig Reading Data](../doc/source/big-data/pig/PigLoadStoreOperators.md)
        - [Pig Storing Data](../doc/source/big-data/pig/PigLoadStoreOperators.md#storing-data)
    - [Diagnostic Operators](../doc/source/big-data/pig/PigDiagnosticOperators.md)
        - [Pig Dump Operator](../doc/source/big-data/pig/PigDiagnosticOperators.md#dump-operator)
        - [Pig Describe Operator](../doc/source/big-data/pig/PigDiagnosticOperators.md#describe-operator)
        - [Pig Explain Operator](../doc/source/big-data/pig/PigDiagnosticOperators.md#explain-operator)
        - [Pig Illustrate Operator](../doc/source/big-data/pig/PigDiagnosticOperators.md#illustrate-operator)
    - [Grouping & Joining](../doc/source/big-data/pig/PigGroupOperator.md)
        - [Pig Group Operator](../doc/source/big-data/pig/PigGroupOperator.md)
        - [Pig Cogroup Operator](../doc/source/big-data/pig/PigCogroupOperator.md)
        - [Pig Join Operator](../doc/source/big-data/pig/PigJoinOperator.md)
        - [Pig Cross Operator](../doc/source/big-data/pig/PigCrossOperator.md)
    - [Combining & Splitting](../doc/source/big-data/pig/PigCombiningSplitting.md)
        - [Pig Union Operator](../doc/source/big-data/pig/PigCombiningSplitting.md)
        - [Pig Split Operator](../doc/source/big-data/pig/PigCombiningSplitting.md#split-operator)
    - [Filtering](../doc/source/big-data/pig/PigFiltering.md)
        - [Pig Filter Operator](../doc/source/big-data/pig/PigFiltering.md)
        - [Pig Distinct Operator](../doc/source/big-data/pig/PigFiltering.md#distinct-operator)
        - [Pig Foreach Operator](../doc/source/big-data/pig/PigFiltering.md#foreach-operator)
    - [Sorting](../doc/source/big-data/pig/PigSorting.md)
        - [Pig Order By](../doc/source/big-data/pig/PigSorting.md)
        - [Pig Limit Operator](../doc/source/big-data/pig/PigSorting.md#limit-operator)
    - [Pig Latin Built-In Functions](../doc/source/big-data/pig/PigEvalFunctions.md)
        - [Pig Eval Functions](../doc/source/big-data/pig/PigEvalFunctions.md)
        - [Pig Load & Store Functions](../doc/source/big-data/pig/PigLoadStoreFunctions.md)
        - [Pig Bag & Tuple Functions](../doc/source/big-data/pig/PigBagTupleFunctions.md)
        - [Pig String Functions](../doc/source/big-data/pig/PigStringFunctions.md)
        - [Pig Date-time Functions](../doc/source/big-data/pig/PigDatetimeFunctions.md)
        - [Pig Math Functions](../doc/source/big-data/pig/PigMathFunctions.md)
    - [Other Modes Of Execution](../doc/source/big-data/pig/PigUserDefinedFunctions.md)
        - [Pig User Defined Functions](../doc/source/big-data/pig/PigUserDefinedFunctions.md)
        - [Pig Running Scripts](../doc/source/big-data/pig/PigRunningScripts.md)

### Impala
- [Impala](impala/README.md)
    - [Impala Overview](../doc/source/big-data/impala/ImpalaOverview.md)


### 3V's of Big Data
1. Velocity: The data is increasing at a very fast rate. It is estimated that the volume of data will double in every 2 years.
1. Variety: Now a days data are not stored in rows and column. Data is structured as well as unstructured. Log file, CCTV footage is unstructured data. Data which can be saved in tables are structured data like the transaction data of the bank.
1. Volume: The amount of data which we deal with is of very large size of Peta bytes.
