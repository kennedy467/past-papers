package com.ken.UniversityApp.model

object PaperData {

    private val allPapers = listOf(
        // Year 1, Semester 1 Units
        Paper(
            id = "mcs_1101_2023",
            paperTitle = "SCS 1101 Fundamentals of Computing - 2023",
            unitCode = "SCS 1101",
            unitName = "Fundamentals of Computing",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 1101_2023_page1.jpg", "SCS 1101_2023_page2.jpg"),
            remoteUrl = "https://github.com/kennedy467/past-papers/blob/main/WhatsApp%20Image%202025-11-29%20at%2015.15.33_705b8bb0.jpg?raw=true",
            fileSize = "2.5 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_1102_2023",
            paperTitle = "SCS 1102 Introduction to Programming - 2023",
            unitCode = "SCS 1102",
            unitName = "Introduction to Programming",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 1102_2023_page1.jpg", "SCS 1102_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.5 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sph1101_2023",
            paperTitle = "SPH 1101 Electrical Principles - 2023",
            unitCode = "SPH 1101",
            unitName = "Electrical Principles",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SPH 1101_2023_page1.jpg", "SPH 1101_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.0 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_1103_2023",
            paperTitle = "SCS 1103 Computer Applications - 2023",
            unitCode = "SCS 1103",
            unitName = "Computer Applications",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 1103_2023_page1.jpg", "SCS 1103_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.8 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma1101_2023",
            paperTitle = "SMA 1101 Descriptive Statistics - 2023",
            unitCode = "SMA 1101",
            unitName = "Descriptive Statistics",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1101_2023_page1.jpg", "SMA 1101_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.7 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma1102_2023",
            paperTitle = "SMA 1102 Introduction to Probability Theory - 2023",
            unitCode = "SMA 1102",
            unitName = "Introduction to Probability Theory",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1102_2023_page1.jpg", "SMA 1102_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.9 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma1103_2023",
            paperTitle = "SMA 1103 Analytical Geometry - 2023",
            unitCode = "SMA 1103",
            unitName = "Analytical Geometry",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1103_2023_page1.jpg", "SMA 1103_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.6 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma1104_2023",
            paperTitle = "SMA 1104 Foundations of Pure Mathematics - 2023",
            unitCode = "SMA 1104",
            unitName = "Foundations of Pure Mathematics",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1104_2023_page1.jpg", "SMA 1104_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.8 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma1105_2023",
            paperTitle = "SMA 1105 Basic Mathematics - 2023",
            unitCode = "SMA 1105",
            unitName = "Basic Mathematics",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1105_2023_page1.jpg", "SMA 1105_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.5 MB",
            semester = "1"
        ),

        // Year 1, Semester 2 Units
        Paper(
            id = "mcs_sma1201_2023",
            paperTitle = "SMA 1201 Calculus 1 - 2023",
            unitCode = "SMA 1201",
            unitName = "Calculus 1",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1201_2023_page1.jpg", "SMA 1201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.2 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma1202_2023",
            paperTitle = "SMA 1202 Foundation of Applied Math - 2023",
            unitCode = "SMA 1202",
            unitName = "Foundation of Applied Math",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1202_2023_page1.jpg", "SMA 1202_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.9 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma1203_2023",
            paperTitle = "SMA 1203 Discrete Math - 2023",
            unitCode = "SMA 1203",
            unitName = "Discrete Math",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1203_2023_page1.jpg", "SMA 1203_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.0 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma1204_2023",
            paperTitle = "SMA 1204 Linear Algebra - 2023",
            unitCode = "SMA 1204",
            unitName = "Linear Algebra",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 1204_2023_page1.jpg", "SMA 1204_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.8 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs1201_2023",
            paperTitle = "SCS 1201 Object Oriented Programming 1 - 2023",
            unitCode = "SCS 1201",
            unitName = "Object Oriented Programming 1",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 1201_2023_page1.jpg", "SCS 1201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.3 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs1202_2023",
            paperTitle = "SCS 1202 Database Systems - 2023",
            unitCode = "SCS 1202",
            unitName = "Database Systems",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 1202_2023_page1.jpg", "SCS 1202_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.1 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs1203_2023",
            paperTitle = "SCS 1203 System Analysis and Design - 2023",
            unitCode = "SCS 1203",
            unitName = "System Analysis and Design",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 1203_2023_page1.jpg", "SCS 1203_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.9 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sph1201_2023",
            paperTitle = "SPH 1201 Electronics - 2023",
            unitCode = "SPH 1201",
            unitName = "Electronics",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SPH 1201_2023_page1.jpg", "SPH 1201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.8 MB",
            semester = "2"
        ),

        // Year 2, Semester 1 Units
        Paper(
            id = "mcs_scs2101_2023",
            paperTitle = "SCS 2101 Object Oriented Programming 2 - 2023",
            unitCode = "SCS 2101",
            unitName = "Object Oriented Programming 2",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2101_2023_page1.jpg", "SCS 2101_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.4 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma2101_2023",
            paperTitle = "SMA 2101 Vector Analysis 2 - 2023",
            unitCode = "SMA 2101",
            unitName = "Vector Analysis 2",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 2101_2023_page1.jpg", "SMA 2101_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.1 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma2102_2023",
            paperTitle = "SMA 2102 Calculus 2 - 2023",
            unitCode = "SMA 2102",
            unitName = "Calculus 2",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 2102_2023_page1.jpg", "SMA 2102_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.2 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma2103_2023",
            paperTitle = "SMA 2103 Numerical Analysis - 2023",
            unitCode = "SMA 2103",
            unitName = "Numerical Analysis",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 2103_2023_page1.jpg", "SMA 2103_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.0 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma2104_2023",
            paperTitle = "SMA 2104 Discrete 2 - 2023",
            unitCode = "SMA 2104",
            unitName = "Discrete 2",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 2104_2023_page1.jpg", "SMA 2104_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "2.9 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs2102_2023",
            paperTitle = "SCS 2102 System and Procedural Programming - 2023",
            unitCode = "SCS 2102",
            unitName = "System and Procedural Programming",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2102_2023_page1.jpg", "SCS 2102_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.3 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs2103_2023",
            paperTitle = "SCS 2103 LAN Design - 2023",
            unitCode = "SCS 2103",
            unitName = "LAN Design",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2103_2023_page1.jpg", "SCS 2103_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.1 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs2104_2023",
            paperTitle = "SCS 2104 Data Structures and Algorithms - 2023",
            unitCode = "SCS 2104",
            unitName = "Data Structures and Algorithms",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2104_2023_page1.jpg", "SCS 2104_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.5 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs2105_2023",
            paperTitle = "SCS 2105 Computing Project Methodologies and Technical Report Writings - 2023",
            unitCode = "SCS 2105",
            unitName = "Computing Project Methodologies and Technical Report Writings",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2105_2023_page1.jpg", "SCS 2105_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.2 MB",
            semester = "1"
        ),

        // Year 2, Semester 2 Units
        Paper(
            id = "mcs_sma2201_2023",
            paperTitle = "SMA 2201 Complex Analysis - 2023",
            unitCode = "SMA 2201",
            unitName = "Complex Analysis",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 2201_2023_page1.jpg", "SMA 2201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.3 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma2202_2023",
            paperTitle = "SMA 2202 Differential Equations - 2023",
            unitCode = "SMA 2202",
            unitName = "Differential Equations",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 2202_2023_page1.jpg", "SMA 2202_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.1 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma2203_2023",
            paperTitle = "SMA 2203 Probability and Statistics 2 - 2023",
            unitCode = "SMA 2203",
            unitName = "Probability and Statistics 2",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 2203_2023_page1.jpg", "SMA 2203_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.2 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs2201_2023",
            paperTitle = "SCS 2201 Operating Systems - 2023",
            unitCode = "SCS 2201",
            unitName = "Operating Systems",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2201_2023_page1.jpg", "SCS 2201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.4 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs2202_2023",
            paperTitle = "SCS 2202 Computer Networks - 2023",
            unitCode = "SCS 2202",
            unitName = "Computer Networks",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2202_2023_page1.jpg", "SCS 2202_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.3 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs2203_2023",
            paperTitle = "SCS 2203 Software Engineering - 2023",
            unitCode = "SCS 2203",
            unitName = "Software Engineering",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2203_2023_page1.jpg", "SCS 2203_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.5 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs2204_2023",
            paperTitle = "SCS 2204 Web Technologies - 2023",
            unitCode = "SCS 2204",
            unitName = "Web Technologies",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 2204_2023_page1.jpg", "SCS 2204_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.2 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma2204_2023",
            paperTitle = "SMA 2204 Mathematical Modeling - 2023",
            unitCode = "SMA 2204",
            unitName = "Mathematical Modeling",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 2204_2023_page1.jpg", "SMA 2204_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.0 MB",
            semester = "2"
        ),

        // Year 3, Semester 1 Units
        Paper(
            id = "mcs_sma3101_2023",
            paperTitle = "SMA 3101 Real Analysis - 2023",
            unitCode = "SMA 3101",
            unitName = "Real Analysis",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 3101_2023_page1.jpg", "SMA 3101_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.4 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma3102_2023",
            paperTitle = "SMA 3102 Abstract Algebra - 2023",
            unitCode = "SMA 3102",
            unitName = "Abstract Algebra",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 3102_2023_page1.jpg", "SMA 3102_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.3 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs3101_2023",
            paperTitle = "SCS 3101 Artificial Intelligence - 2023",
            unitCode = "SCS 3101",
            unitName = "Artificial Intelligence",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 3101_2023_page1.jpg", "SCS 3101_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.6 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs3102_2023",
            paperTitle = "SCS 3102 Mobile Application Development - 2023",
            unitCode = "SCS 3102",
            unitName = "Mobile Application Development",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 3102_2023_page1.jpg", "SCS 3102_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.5 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs3103_2023",
            paperTitle = "SCS 3103 Computer Graphics - 2023",
            unitCode = "SCS 3103",
            unitName = "Computer Graphics",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 3103_2023_page1.jpg", "SCS 3103_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.7 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma3103_2023",
            paperTitle = "SMA 3103 Operations Research - 2023",
            unitCode = "SMA 3103",
            unitName = "Operations Research",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 3103_2023_page1.jpg", "SMA 3103_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.4 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs3104_2023",
            paperTitle = "SCS 3104 Network Security - 2023",
            unitCode = "SCS 3104",
            unitName = "Network Security",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 3104_2023_page1.jpg", "SCS 3104_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.6 MB",
            semester = "1"
        ),

        // Year 3, Semester 2 Units
        Paper(
            id = "mcs_sma3201_2023",
            paperTitle = "SMA 3201 Partial Differential Equations - 2023",
            unitCode = "SMA 3201",
            unitName = "Partial Differential Equations",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 3201_2023_page1.jpg", "SMA 3201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.5 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma3202_2023",
            paperTitle = "SMA 3202 Topology - 2023",
            unitCode = "SMA 3202",
            unitName = "Topology",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 3202_2023_page1.jpg", "SMA 3202_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.4 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs3201_2023",
            paperTitle = "SCS 3201 Machine Learning - 2023",
            unitCode = "SCS 3201",
            unitName = "Machine Learning",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 3201_2023_page1.jpg", "SCS 3201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.8 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs3202_2023",
            paperTitle = "SCS 3202 Distributed Systems - 2023",
            unitCode = "SCS 3202",
            unitName = "Distributed Systems",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 3202_2023_page1.jpg", "SCS 3202_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.6 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs3203_2023",
            paperTitle = "SCS 3203 Cloud Computing - 2023",
            unitCode = "SCS 3203",
            unitName = "Cloud Computing",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 3203_2023_page1.jpg", "SCS 3203_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.7 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma3203_2023",
            paperTitle = "SMA 3203 Financial Mathematics - 2023",
            unitCode = "SMA 3203",
            unitName = "Financial Mathematics",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 3203_2023_page1.jpg", "SMA 3203_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.5 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs3204_2023",
            paperTitle = "SCS 3204 Human Computer Interaction - 2023",
            unitCode = "SCS 3204",
            unitName = "Human Computer Interaction",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 3204_2023_page1.jpg", "SCS 3204_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.4 MB",
            semester = "2"
        ),

        // Year 4, Semester 1 Units
        Paper(
            id = "mcs_sma4101_2023",
            paperTitle = "SMA 4101 Project in Mathematics - 2023",
            unitCode = "SMA 4101",
            unitName = "Project in Mathematics",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 4101_2023_page1.jpg", "SMA 4101_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.8 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs4101_2023",
            paperTitle = "SCS 4101 Project in Computer Science - 2023",
            unitCode = "SCS 4101",
            unitName = "Project in Computer Science",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 4101_2023_page1.jpg", "SCS 4101_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.9 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_sma4102_2023",
            paperTitle = "SMA 4102 Functional Analysis - 2023",
            unitCode = "SMA 4102",
            unitName = "Functional Analysis",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 4102_2023_page1.jpg", "SMA 4102_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.7 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs4102_2023",
            paperTitle = "SCS 4102 Big Data Analytics - 2023",
            unitCode = "SCS 4102",
            unitName = "Big Data Analytics",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 4102_2023_page1.jpg", "SCS 4102_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "4.0 MB",
            semester = "1"
        ),
        Paper(
            id = "mcs_scs4103_2023",
            paperTitle = "SCS 4103 Internet of Things - 2023",
            unitCode = "SCS 4103",
            unitName = "Internet of Things",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 4103_2023_page1.jpg", "SCS 4103_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.8 MB",
            semester = "1"
        ),

        // Year 4, Semester 2 Units
        Paper(
            id = "mcs_sma4201_2023",
            paperTitle = "SMA 4201 Advanced Numerical Methods - 2023",
            unitCode = "SMA 4201",
            unitName = "Advanced Numerical Methods",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 4201_2023_page1.jpg", "SMA 4201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.8 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs4201_2023",
            paperTitle = "SCS 4201 Advanced Software Engineering - 2023",
            unitCode = "SCS 4201",
            unitName = "Advanced Software Engineering",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 4201_2023_page1.jpg", "SCS 4201_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "4.0 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_sma4202_2023",
            paperTitle = "SMA 4202 Number Theory - 2023",
            unitCode = "SMA 4202",
            unitName = "Number Theory",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SMA 4202_2023_page1.jpg", "SMA 4202_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.7 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs4202_2023",
            paperTitle = "SCS 4202 Natural Language Processing - 2023",
            unitCode = "SCS 4202",
            unitName = "Natural Language Processing",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 4202_2023_page1.jpg", "SCS 4202_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "3.9 MB",
            semester = "2"
        ),
        Paper(
            id = "mcs_scs4203_2023",
            paperTitle = "SCS 4203 Blockchain Technology - 2023",
            unitCode = "SCS 4203",
            unitName = "Blockchain Technology",
            year = 2023,
            paperType = "Main Exam",
            fileNames = listOf("SCS 4203_2023_page1.jpg", "SCS 4203_2023_page2.jpg"),
            remoteUrl = "",
            fileSize = "4.1 MB",
            semester = "2"
        )
    )

    // Functions to get papers
    fun getAllPapers(): List<Paper> {
        return allPapers
    }

    fun getPapersByUnitCode(unitCode: String): List<Paper> {
        return allPapers.filter { it.unitCode == unitCode }
    }

    fun getPaperById(id: String): Paper? {
        return allPapers.find { it.id == id }
    }

    fun getPapersByYear(year: Int): List<Paper> {
        return allPapers.filter { it.year == year }
    }

    fun getPapersBySemester(semester: String): List<Paper> {
        return allPapers.filter { it.semester == semester }
    }

    fun getPapersByType(paperType: String): List<Paper> {
        return allPapers.filter { it.paperType == paperType }
    }

    fun getAvailableYears(): List<Int> {
        return allPapers.map { it.year }.distinct().sortedDescending()
    }

    fun getAvailableUnitCodes(): List<String> {
        return allPapers.map { it.unitCode }.distinct().sorted()
    }

    // New function to get papers by semester and year
    fun getPapersBySemesterAndYear(semester: String, year: Int): List<Paper> {
        return allPapers.filter { it.semester == semester && it.year == year }
    }

    // New function to get papers by unit code and year
    fun getPapersByUnitCodeAndYear(unitCode: String, year: Int): List<Paper> {
        return allPapers.filter { it.unitCode == unitCode && it.year == year }
    }

    // New function to get available semesters for a given year
    fun getAvailableSemestersForYear(year: Int): List<String> {
        return allPapers.filter { it.year == year }
            .map { it.semester }
            .distinct()
            .sorted()
    }
}