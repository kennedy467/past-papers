package com.ken.UniversityApp.model

import com.ken.UniversityApp.model.CourseUnit

object UnitData {

    fun getUnitsByCourseYearSemester(courseId: String, year: Int, semester: Int): List<CourseUnit> {
        return when (courseId) {
            "bsc_mcs" -> getMCSUnits(year, semester)
            "bsc_cs" -> getComputerScienceUnits(year, semester)
            "bsc_se" -> getSoftwareEngineeringUnits(year, semester)
            "bsc_it" -> getInformationTechnologyUnits(year, semester)
            "bsc_ds" -> getDataScienceUnits(year, semester)
            "bsc_ai" -> getArtificialIntelligenceUnits(year, semester)
            "bsc_cyber" -> getCybersecurityUnits(year, semester)
            "bsc_stats" -> getStatisticsUnits(year, semester)
            "bsc_actuary" -> getActuarialScienceUnits(year, semester)
            "bsc_math" -> getPureMathematicsUnits(year, semester)
            else -> emptyList()
        }
    }

    private fun getMCSUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SCS 1101", "Fundamentals of Computing"),
                    CourseUnit("SCS 1102", "Introduction to Programming"),
                    CourseUnit("SPH 1101", "Electrical Principles"),
                    CourseUnit("SCS 1103", "Computer Applications"),
                    CourseUnit("SMA 1101", "Descriptive Statistics"),
                    CourseUnit("SMA 1102", "Introduction to Probability Theory"),
                    CourseUnit("SMA 1103", "Analytical Geometry"),
                    CourseUnit("SMA 1104", "Foundations of Pure Mathematics"),
                    CourseUnit("SMA 1105", "Basic Mathematics")
                )
                2 -> listOf(
                    CourseUnit("SMA 1201", "Calculus 1"),
                    CourseUnit("SMA 1202", "Foundation of Applied Math"),
                    CourseUnit("SMA 1203", "Discrete Math"),
                    CourseUnit("SMA 1204", "Linear Algebra"),
                    CourseUnit("SCS 1201", "Object Oriented Programming 1"),
                    CourseUnit("SCS 1202", "Database Systems"),
                    CourseUnit("SCS 1203", "System Analysis and Design"),
                    CourseUnit("SPH 1201", "Electronics")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SCS 2101", "Object Oriented Programming 2"),
                    CourseUnit("SMA 2101", "Vector Analysis 2"),
                    CourseUnit("SMA 2102", "Calculus 2"),
                    CourseUnit("SMA 2103", "Numerical Analysis"),
                    CourseUnit("SMA 2104", "Discrete 2"),
                    CourseUnit("SCS 2102", "System and Procedural Programming"),
                    CourseUnit("SCS 2103", "LAN Design"),
                    CourseUnit("SCS 2104", "Data Structures and Algorithms"),
                    CourseUnit("SCS 2105", "Computing Project Methodologies and Technical Report Writings")
                )
                2 -> listOf(
                    CourseUnit("SMA 2201", "Complex Analysis"),
                    CourseUnit("SMA 2202", "Differential Equations"),
                    CourseUnit("SMA 2203", "Probability and Statistics 2"),
                    CourseUnit("SCS 2201", "Operating Systems"),
                    CourseUnit("SCS 2202", "Computer Networks"),
                    CourseUnit("SCS 2203", "Software Engineering"),
                    CourseUnit("SCS 2204", "Web Technologies"),
                    CourseUnit("SMA 2204", "Mathematical Modeling")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SMA 3101", "Real Analysis"),
                    CourseUnit("SMA 3102", "Abstract Algebra"),
                    CourseUnit("SCS 3101", "Artificial Intelligence"),
                    CourseUnit("SCS 3102", "Mobile Application Development"),
                    CourseUnit("SCS 3103", "Computer Graphics"),
                    CourseUnit("SMA 3103", "Operations Research"),
                    CourseUnit("SCS 3104", "Network Security")
                )
                2 -> listOf(
                    CourseUnit("SMA 3201", "Partial Differential Equations"),
                    CourseUnit("SMA 3202", "Topology"),
                    CourseUnit("SCS 3201", "Machine Learning"),
                    CourseUnit("SCS 3202", "Distributed Systems"),
                    CourseUnit("SCS 3203", "Cloud Computing"),
                    CourseUnit("SMA 3203", "Financial Mathematics"),
                    CourseUnit("SCS 3204", "Human Computer Interaction")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SMA 4101", "Project in Mathematics"),
                    CourseUnit("SCS 4101", "Project in Computer Science"),
                    CourseUnit("SMA 4102", "Functional Analysis"),
                    CourseUnit("SCS 4102", "Big Data Analytics"),
                    CourseUnit("SCS 4103", "Internet of Things")
                )
                2 -> listOf(
                    CourseUnit("SMA 4201", "Advanced Numerical Methods"),
                    CourseUnit("SCS 4201", "Advanced Software Engineering"),
                    CourseUnit("SMA 4202", "Number Theory"),
                    CourseUnit("SCS 4202", "Natural Language Processing"),
                    CourseUnit("SCS 4203", "Blockchain Technology")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }

    private fun getComputerScienceUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SCS 1101", "Fundamentals of Computing"),
                    CourseUnit("SCS 1102", "Introduction to Programming"),
                    CourseUnit("SMA 1101", "Calculus I"),
                    CourseUnit("SMA 1102", "Algebra"),
                    CourseUnit("SCS 1103", "Computer Applications")
                )
                2 -> listOf(
                    CourseUnit("SCS 1201", "Object Oriented Programming"),
                    CourseUnit("SCS 1202", "Discrete Mathematics"),
                    CourseUnit("SMA 1201", "Calculus II"),
                    CourseUnit("SCS 1203", "Digital Logic Design"),
                    CourseUnit("SCS 1204", "Communication Skills")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SCS 2101", "Data Structures and Algorithms"),
                    CourseUnit("SCS 2102", "Computer Organization"),
                    CourseUnit("SCS 2103", "Database Systems"),
                    CourseUnit("SMA 2101", "Probability and Statistics"),
                    CourseUnit("SCS 2104", "System Analysis and Design")
                )
                2 -> listOf(
                    CourseUnit("SCS 2201", "Operating Systems"),
                    CourseUnit("SCS 2202", "Computer Networks"),
                    CourseUnit("SCS 2203", "Web Technologies"),
                    CourseUnit("SCS 2204", "Software Engineering"),
                    CourseUnit("SCS 2205", "Research Methods")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SCS 3101", "Artificial Intelligence"),
                    CourseUnit("SCS 3102", "Mobile Application Development"),
                    CourseUnit("SCS 3103", "Computer Graphics"),
                    CourseUnit("SCS 3104", "Network Security"),
                    CourseUnit("SCS 3105", "Software Project Management")
                )
                2 -> listOf(
                    CourseUnit("SCS 3201", "Machine Learning"),
                    CourseUnit("SCS 3202", "Distributed Systems"),
                    CourseUnit("SCS 3203", "Cloud Computing"),
                    CourseUnit("SCS 3204", "Human Computer Interaction"),
                    CourseUnit("SCS 3205", "Ethics in Computing")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SCS 4101", "Project in Computer Science"),
                    CourseUnit("SCS 4102", "Big Data Analytics"),
                    CourseUnit("SCS 4103", "Internet of Things"),
                    CourseUnit("SCS 4104", "Advanced Algorithms")
                )
                2 -> listOf(
                    CourseUnit("SCS 4201", "Advanced Software Engineering"),
                    CourseUnit("SCS 4202", "Natural Language Processing"),
                    CourseUnit("SCS 4203", "Blockchain Technology"),
                    CourseUnit("SCS 4204", "Career Development")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }

    private fun getSoftwareEngineeringUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BSE 1101", "Introduction to Software Engineering"),
                    CourseUnit("BSE 1102", "Programming Fundamentals"),
                    CourseUnit("BSE 1103", "Discrete Mathematics"),
                    CourseUnit("BSE 1104", "Computer Systems"),
                    CourseUnit("BSE 1105", "Computational Thinking")
                )
                2 -> listOf(
                    CourseUnit("BSE 1201", "Object-Oriented Programming"),
                    CourseUnit("BSE 1202", "Data Structures"),
                    CourseUnit("BSE 1203", "Database Concepts"),
                    CourseUnit("BSE 1204", "Web Technologies"),
                    CourseUnit("BSE 1205", "Software Requirements Engineering")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BSE 2101", "Software Design Patterns"),
                    CourseUnit("BSE 2102", "Web Application Development"),
                    CourseUnit("BSE 2103", "Software Testing"),
                    CourseUnit("BSE 2104", "User Interface Design"),
                    CourseUnit("BSE 2105", "Algorithms and Complexity")
                )
                2 -> listOf(
                    CourseUnit("BSE 2201", "Software Architecture"),
                    CourseUnit("BSE 2202", "Mobile App Development"),
                    CourseUnit("BSE 2203", "Software Quality Assurance"),
                    CourseUnit("BSE 2204", "Agile Methodologies"),
                    CourseUnit("BSE 2205", "Database Management Systems")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BSE 3101", "Enterprise Software Development"),
                    CourseUnit("BSE 3102", "Software Project Management"),
                    CourseUnit("BSE 3103", "Cloud Computing"),
                    CourseUnit("BSE 3104", "DevOps Practices"),
                    CourseUnit("BSE 3105", "Software Metrics and Measurement")
                )
                2 -> listOf(
                    CourseUnit("BSE 3201", "Distributed Systems"),
                    CourseUnit("BSE 3202", "Software Maintenance"),
                    CourseUnit("BSE 3203", "Software Security"),
                    CourseUnit("BSE 3204", "Human-Computer Interaction"),
                    CourseUnit("BSE 3205", "Research Methods")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BSE 4101", "Software Engineering Project I"),
                    CourseUnit("BSE 4102", "Software Product Management"),
                    CourseUnit("BSE 4103", "Big Data Systems"),
                    CourseUnit("BSE 4104", "Machine Learning for Software Engineering"),
                    CourseUnit("BSE 4105", "Software Economics")
                )
                2 -> listOf(
                    CourseUnit("BSE 4201", "Software Engineering Project II"),
                    CourseUnit("BSE 4202", "Software Process Improvement"),
                    CourseUnit("BSE 4203", "Emerging Technologies"),
                    CourseUnit("BSE 4204", "Professional Ethics"),
                    CourseUnit("BSE 4205", "Career Preparation")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }

    private fun getInformationTechnologyUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BIT 1101", "Introduction to Information Technology"),
                    CourseUnit("BIT 1102", "Computer Applications"),
                    CourseUnit("BIT 1103", "Programming Basics"),
                    CourseUnit("BIT 1104", "Business Mathematics"),
                    CourseUnit("BIT 1105", "Computer Hardware Fundamentals")
                )
                2 -> listOf(
                    CourseUnit("BIT 1201", "Database Management"),
                    CourseUnit("BIT 1202", "Web Design"),
                    CourseUnit("BIT 1203", "Networking Fundamentals"),
                    CourseUnit("BIT 1204", "System Administration"),
                    CourseUnit("BIT 1205", "Business Communication")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BIT 2101", "Systems Analysis and Design"),
                    CourseUnit("BIT 2102", "Object-Oriented Programming"),
                    CourseUnit("BIT 2103", "Network Administration"),
                    CourseUnit("BIT 2104", "Database Systems"),
                    CourseUnit("BIT 2105", "IT Project Management")
                )
                2 -> listOf(
                    CourseUnit("BIT 2201", "Web Application Development"),
                    CourseUnit("BIT 2202", "Information Security"),
                    CourseUnit("BIT 2203", "Cloud Computing"),
                    CourseUnit("BIT 2204", "Mobile Computing"),
                    CourseUnit("BIT 2205", "Business Process Management")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BIT 3101", "Enterprise Systems"),
                    CourseUnit("BIT 3102", "Data Analytics"),
                    CourseUnit("BIT 3103", "IT Infrastructure Management"),
                    CourseUnit("BIT 3104", "E-Commerce Systems"),
                    CourseUnit("BIT 3105", "IT Governance")
                )
                2 -> listOf(
                    CourseUnit("BIT 3201", "IT Service Management"),
                    CourseUnit("BIT 3202", "Business Intelligence"),
                    CourseUnit("BIT 3203", "Social Media Technologies"),
                    CourseUnit("BIT 3204", "Strategic IT Management"),
                    CourseUnit("BIT 3205", "Research Methods")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BIT 4101", "IT Capstone Project I"),
                    CourseUnit("BIT 4102", "Emerging Technologies"),
                    CourseUnit("BIT 4103", "IT Law and Ethics"),
                    CourseUnit("BIT 4104", "Enterprise Architecture"),
                    CourseUnit("BIT 4105", "IT Consulting")
                )
                2 -> listOf(
                    CourseUnit("BIT 4201", "IT Capstone Project II"),
                    CourseUnit("BIT 4202", "Digital Transformation"),
                    CourseUnit("BIT 4203", "IT Leadership"),
                    CourseUnit("BIT 4204", "Global IT Management"),
                    CourseUnit("BIT 4205", "Professional Development")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }
    private fun getDataScienceUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BDS 1101", "Introduction to Data Science"),
                    CourseUnit("BDS 1102", "Programming for Data Science"),
                    CourseUnit("BDS 1103", "Calculus I"),
                    CourseUnit("BDS 1104", "Linear Algebra"),
                    CourseUnit("BDS 1105", "Statistical Computing")
                )
                2 -> listOf(
                    CourseUnit("BDS 1201", "Probability Theory"),
                    CourseUnit("BDS 1202", "Data Structures and Algorithms"),
                    CourseUnit("BDS 1203", "Database Systems"),
                    CourseUnit("BDS 1204", "Calculus II"),
                    CourseUnit("BDS 1205", "Data Visualization")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BDS 2101", "Statistical Inference"),
                    CourseUnit("BDS 2102", "Machine Learning Fundamentals"),
                    CourseUnit("BDS 2103", "Data Wrangling and Preprocessing"),
                    CourseUnit("BDS 2104", "Multivariate Calculus"),
                    CourseUnit("BDS 2105", "Database Management Systems")
                )
                2 -> listOf(
                    CourseUnit("BDS 2201", "Regression Analysis"),
                    CourseUnit("BDS 2202", "Data Mining"),
                    CourseUnit("BDS 2203", "Big Data Technologies"),
                    CourseUnit("BDS 2204", "Time Series Analysis"),
                    CourseUnit("BDS 2205", "Business Intelligence")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BDS 3101", "Advanced Machine Learning"),
                    CourseUnit("BDS 3102", "Deep Learning"),
                    CourseUnit("BDS 3103", "Natural Language Processing"),
                    CourseUnit("BDS 3104", "Cloud Computing for Data Science"),
                    CourseUnit("BDS 3105", "Experimental Design")
                )
                2 -> listOf(
                    CourseUnit("BDS 3201", "Computer Vision"),
                    CourseUnit("BDS 3202", "Recommender Systems"),
                    CourseUnit("BDS 3203", "Data Engineering"),
                    CourseUnit("BDS 3204", "Statistical Modeling"),
                    CourseUnit("BDS 3205", "Research Methods in Data Science")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BDS 4101", "Data Science Capstone Project I"),
                    CourseUnit("BDS 4102", "Advanced Deep Learning"),
                    CourseUnit("BDS 4103", "Big Data Analytics"),
                    CourseUnit("BDS 4104", "Data Ethics and Privacy"),
                    CourseUnit("BDS 4105", "Data Science in Industry")
                )
                2 -> listOf(
                    CourseUnit("BDS 4201", "Data Science Capstone Project II"),
                    CourseUnit("BDS 4202", "ML Operations (MLOps)"),
                    CourseUnit("BDS 4203", "Real-time Analytics"),
                    CourseUnit("BDS 4204", "Data Strategy and Governance"),
                    CourseUnit("BDS 4205", "Professional Development")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }

    private fun getArtificialIntelligenceUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BAI 1101", "Introduction to Artificial Intelligence"),
                    CourseUnit("BAI 1102", "Python Programming for AI"),
                    CourseUnit("BAI 1103", "Calculus I"),
                    CourseUnit("BAI 1104", "Linear Algebra"),
                    CourseUnit("BAI 1105", "Computational Thinking")
                )
                2 -> listOf(
                    CourseUnit("BAI 1201", "Data Structures for AI"),
                    CourseUnit("BAI 1202", "Probability for AI"),
                    CourseUnit("BAI 1203", "Discrete Mathematics"),
                    CourseUnit("BAI 1204", "Statistics"),
                    CourseUnit("BAI 1205", "Logic and Reasoning")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BAI 2101", "Machine Learning Fundamentals"),
                    CourseUnit("BAI 2102", "Search Algorithms"),
                    CourseUnit("BAI 2103", "Knowledge Representation"),
                    CourseUnit("BAI 2104", "Optimization Methods"),
                    CourseUnit("BAI 2105", "AI Ethics")
                )
                2 -> listOf(
                    CourseUnit("BAI 2201", "Neural Networks"),
                    CourseUnit("BAI 2202", "Natural Language Processing"),
                    CourseUnit("BAI 2203", "Computer Vision"),
                    CourseUnit("BAI 2204", "Reinforcement Learning"),
                    CourseUnit("BAI 2205", "AI System Design")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BAI 3101", "Deep Learning"),
                    CourseUnit("BAI 3102", "Robotics and Planning"),
                    CourseUnit("BAI 3103", "Intelligent Agents"),
                    CourseUnit("BAI 3104", "Bayesian Methods"),
                    CourseUnit("BAI 3105", "AI Hardware")
                )
                2 -> listOf(
                    CourseUnit("BAI 3201", "Advanced NLP"),
                    CourseUnit("BAI 3202", "Computer Vision Systems"),
                    CourseUnit("BAI 3203", "Multi-agent Systems"),
                    CourseUnit("BAI 3204", "Explainable AI"),
                    CourseUnit("BAI 3205", "Research Methods in AI")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BAI 4101", "AI Capstone Project I"),
                    CourseUnit("BAI 4102", "Generative AI"),
                    CourseUnit("BAI 4103", "AI in Healthcare"),
                    CourseUnit("BAI 4104", "Autonomous Systems"),
                    CourseUnit("BAI 4105", "AI Product Management")
                )
                2 -> listOf(
                    CourseUnit("BAI 4201", "AI Capstone Project II"),
                    CourseUnit("BAI 4202", "AI Strategy and Business"),
                    CourseUnit("BAI 4203", "Edge AI"),
                    CourseUnit("BAI 4204", "AI Safety and Alignment"),
                    CourseUnit("BAI 4205", "Professional Practice")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }
    private fun getCybersecurityUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("SCS 1101", "Introduction to Cybersecurity"),
                    CourseUnit("SCS 1102", "Programming Fundamentals"),
                    CourseUnit("SCS 1103", "Computer Networks"),
                    CourseUnit("SMA 1101", "Discrete Mathematics")
                )
                2 -> listOf(
                    CourseUnit("SCS 1201", "Network Security"),
                    CourseUnit("SCS 1202", "Cryptography"),
                    CourseUnit("SCS 1203", "Operating Systems"),
                    CourseUnit("SCS 1204", "Database Security")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }

    private fun getStatisticsUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BST 1101", "Introduction to Statistics"),
                    CourseUnit("BST 1102", "Calculus I"),
                    CourseUnit("BST 1103", "Linear Algebra"),
                    CourseUnit("BST 1104", "Probability Theory I"),
                    CourseUnit("BST 1105", "Statistical Computing I")
                )
                2 -> listOf(
                    CourseUnit("BST 1201", "Descriptive Statistics"),
                    CourseUnit("BST 1202", "Calculus II"),
                    CourseUnit("BST 1203", "Probability Theory II"),
                    CourseUnit("BST 1204", "Statistical Methods"),
                    CourseUnit("BST 1205", "Data Analysis I")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BST 2101", "Statistical Inference"),
                    CourseUnit("BST 2102", "Regression Analysis"),
                    CourseUnit("BST 2103", "Multivariate Analysis"),
                    CourseUnit("BST 2104", "Sampling Techniques"),
                    CourseUnit("BST 2105", "Statistical Computing II")
                )
                2 -> listOf(
                    CourseUnit("BST 2201", "Time Series Analysis"),
                    CourseUnit("BST 2202", "Experimental Design"),
                    CourseUnit("BST 2203", "Nonparametric Statistics"),
                    CourseUnit("BST 2204", "Statistical Quality Control"),
                    CourseUnit("BST 2205", "Data Analysis II")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BST 3101", "Bayesian Statistics"),
                    CourseUnit("BST 3102", "Stochastic Processes"),
                    CourseUnit("BST 3103", "Statistical Modeling"),
                    CourseUnit("BST 3104", "Biostatistics"),
                    CourseUnit("BST 3105", "Financial Statistics")
                )
                2 -> listOf(
                    CourseUnit("BST 3201", "Spatial Statistics"),
                    CourseUnit("BST 3202", "Survival Analysis"),
                    CourseUnit("BST 3203", "Statistical Computing III"),
                    CourseUnit("BST 3204", "Statistical Consulting"),
                    CourseUnit("BST 3205", "Research Methods in Statistics")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BST 4101", "Statistics Capstone Project I"),
                    CourseUnit("BST 4102", "Advanced Statistical Theory"),
                    CourseUnit("BST 4103", "Machine Learning for Statisticians"),
                    CourseUnit("BST 4104", "Statistical Ethics"),
                    CourseUnit("BST 4105", "Statistical Software Development")
                )
                2 -> listOf(
                    CourseUnit("BST 4201", "Statistics Capstone Project II"),
                    CourseUnit("BST 4202", "Applied Statistical Projects"),
                    CourseUnit("BST 4203", "Statistical Communication"),
                    CourseUnit("BST 4204", "Professional Development"),
                    CourseUnit("BST 4205", "Industry Applications")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }

    private fun getActuarialScienceUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BAC 1101", "Introduction to Actuarial Science"),
                    CourseUnit("BAC 1102", "Financial Mathematics I"),
                    CourseUnit("BAC 1103", "Probability and Statistics I"),
                    CourseUnit("BAC 1104", "Calculus I"),
                    CourseUnit("BAC 1105", "Microeconomics")
                )
                2 -> listOf(
                    CourseUnit("BAC 1201", "Financial Mathematics II"),
                    CourseUnit("BAC 1202", "Accounting Principles"),
                    CourseUnit("BAC 1203", "Macroeconomics"),
                    CourseUnit("BAC 1204", "Linear Algebra"),
                    CourseUnit("BAC 1205", "Business Communication")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BAC 2101", "Actuarial Mathematics I"),
                    CourseUnit("BAC 2102", "Statistical Methods"),
                    CourseUnit("BAC 2103", "Corporate Finance"),
                    CourseUnit("BAC 2104", "Probability and Statistics II"),
                    CourseUnit("BAC 2105", "Financial Economics")
                )
                2 -> listOf(
                    CourseUnit("BAC 2201", "Actuarial Mathematics II"),
                    CourseUnit("BAC 2202", "Risk Theory"),
                    CourseUnit("BAC 2203", "Investment and Asset Management"),
                    CourseUnit("BAC 2204", "Time Series Analysis"),
                    CourseUnit("BAC 2205", "Business Law")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BAC 3101", "Life Contingencies I"),
                    CourseUnit("BAC 3102", "General Insurance"),
                    CourseUnit("BAC 3103", "Stochastic Processes"),
                    CourseUnit("BAC 3104", "Financial Reporting"),
                    CourseUnit("BAC 3105", "Derivatives Markets")
                )
                2 -> listOf(
                    CourseUnit("BAC 3201", "Life Contingencies II"),
                    CourseUnit("BAC 3202", "Health Insurance"),
                    CourseUnit("BAC 3203", "Loss Models"),
                    CourseUnit("BAC 3204", "Enterprise Risk Management"),
                    CourseUnit("BAC 3205", "Research Methods in Actuarial Science")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BAC 4101", "Actuarial Practice I"),
                    CourseUnit("BAC 4102", "Pension Funds"),
                    CourseUnit("BAC 4103", "Advanced Financial Mathematics"),
                    CourseUnit("BAC 4104", "Reinsurance"),
                    CourseUnit("BAC 4105", "Actuarial Modeling")
                )
                2 -> listOf(
                    CourseUnit("BAC 4201", "Actuarial Practice II"),
                    CourseUnit("BAC 4202", "Specialty Insurance Lines"),
                    CourseUnit("BAC 4203", "Regulatory Framework"),
                    CourseUnit("BAC 4204", "Professional Ethics"),
                    CourseUnit("BAC 4205", "Capstone Project")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }

    private fun getPureMathematicsUnits(year: Int, semester: Int): List<CourseUnit> {
        return when (year) {
            1 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BPM 1101", "Calculus I"),
                    CourseUnit("BPM 1102", "Linear Algebra I"),
                    CourseUnit("BPM 1103", "Introduction to Mathematical Reasoning"),
                    CourseUnit("BPM 1104", "Geometry"),
                    CourseUnit("BPM 1105", "Discrete Mathematics"),
                    CourseUnit("SCS 1102", "Introduction to Programming"),
                            CourseUnit("SMA 1203", "Discrete Math"),
                                    CourseUnit("SMA 1101", "Descriptive Statistics")
                )
                2 -> listOf(
                    CourseUnit("BPM 1201", "Calculus II"),
                    CourseUnit("BPM 1202", "Linear Algebra II"),
                    CourseUnit("BPM 1203", "Differential Equations"),
                    CourseUnit("BPM 1204", "Number Theory"),
                    CourseUnit("BPM 1205", "Mathematical Computing")
                )
                else -> emptyList()
            }
            2 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BPM 2101", "Real Analysis I"),
                    CourseUnit("BPM 2102", "Abstract Algebra I"),
                    CourseUnit("BPM 2103", "Complex Analysis I"),
                    CourseUnit("BPM 2104", "Vector Calculus"),
                    CourseUnit("BPM 2105", "Mathematical Statistics")
                )
                2 -> listOf(
                    CourseUnit("BPM 2201", "Real Analysis II"),
                    CourseUnit("BPM 2202", "Abstract Algebra II"),
                    CourseUnit("BPM 2203", "Complex Analysis II"),
                    CourseUnit("BPM 2204", "Numerical Analysis"),
                    CourseUnit("BPM 2205", "Mathematical Modeling")
                )
                else -> emptyList()
            }
            3 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BPM 3101", "Topology"),
                    CourseUnit("BPM 3102", "Differential Geometry"),
                    CourseUnit("BPM 3103", "Partial Differential Equations"),
                    CourseUnit("BPM 3104", "Number Theory II"),
                    CourseUnit("BPM 3105", "Mathematical Logic")
                )
                2 -> listOf(
                    CourseUnit("BPM 3201", "Functional Analysis"),
                    CourseUnit("BPM 3202", "Algebraic Structures"),
                    CourseUnit("BPM 3203", "Measure Theory"),
                    CourseUnit("BPM 3204", "Combinatorics"),
                    CourseUnit("BPM 3205", "Research Methods in Mathematics")
                )
                else -> emptyList()
            }
            4 -> when (semester) {
                1 -> listOf(
                    CourseUnit("BPM 4101", "Advanced Topics in Analysis"),
                    CourseUnit("BPM 4102", "Advanced Algebra"),
                    CourseUnit("BPM 4103", "Mathematical Physics"),
                    CourseUnit("BPM 4104", "History of Mathematics"),
                    CourseUnit("BPM 4105", "Mathematics Capstone Project I")
                )
                2 -> listOf(
                    CourseUnit("BPM 4201", "Advanced Topics in Geometry"),
                    CourseUnit("BPM 4202", "Category Theory"),
                    CourseUnit("BPM 4203", "Mathematical Research Seminar"),
                    CourseUnit("BPM 4204", "Mathematics Education"),
                    CourseUnit("BPM 4205", "Mathematics Capstone Project II")
                )
                else -> emptyList()
            }
            else -> emptyList()
        }
    }
}