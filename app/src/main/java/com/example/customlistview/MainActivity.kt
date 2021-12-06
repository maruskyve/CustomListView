package com.example.customlistview

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import java.util.*

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // buat data source
        val number = arrayOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12)
        val title = arrayOf<String>("C", "C++", "Java", "Kotlin", "Ruby","Phyton", "Javascript", "Net", "Perl", "PHP", "Ajax", "Golang")
        val desc = arrayOf<String>(
            "bahasa C adalah................",
            "bahasa C++ adalah................",
            "bahasa Java adalah................",
            "bahasa Kotlin adalah................",
            "bahasa Ruby adalah................",
            "bahasa Phyton adalah................",
            "bahasa javascript adalah................",
            "bahasa Net adalah................",
            "bahasa Perl adalah................",
            "bahasa PHP adalah................",
            "bahasa Ajax adalah................",
            "bahasa Golang adalah................"
        )
        val thumbnailPaths = arrayOf<Int>(
            R.drawable.c_logo_100, R.drawable.cpp_logo_100, R.drawable.java_logo_100,
            R.drawable.kotlin_logo_100, R.drawable.ruby_logo_100, R.drawable.python_logo_100,
            R.drawable.js_logo_100, R.drawable.net_logo_100, R.drawable.perl_logo_100,
            R.drawable.php_logo_100, R.drawable.ajax_logo_100, R.drawable.go_logo_100)
        val contentDescs = arrayOf<String>(
            "C (/ˈsiː/, as in the letter c) is a general-purpose, procedural computer programming language supporting structured programming, lexical variable scope, and recursion, with a static type system. By design, C provides constructs that map efficiently to typical machine instructions. It has found lasting use in applications previously coded in assembly language. Such applications include operating systems and various application software for computer architectures that range from supercomputers to PLCs and embedded systems.\n" +
                    "\n" +
                    "A successor to the programming language B, C was originally developed at Bell Labs by Dennis Ritchie between 1972 and 1973 to construct utilities running on Unix. It was applied to re-implementing the kernel of the Unix operating system.[6] During the 1980s, C gradually gained popularity. It has become one of the most widely used programming languages,[7][8] with C compilers from various vendors available for the majority of existing computer architectures and operating systems. C has been standardized by ANSI since 1989 (ANSI C) and by the International Organization for Standardization (ISO).\n" +
                    "\n" +
                    "C is an imperative procedural language. It was designed to be compiled to provide low-level access to memory and language constructs that map efficiently to machine instructions, all with minimal runtime support. Despite its low-level capabilities, the language was designed to encourage cross-platform programming. A standards-compliant C program written with portability in mind can be compiled for a wide variety of computer platforms and operating systems with few changes to its source code.[9]\n" +
                    "\n" +
                    "Since 2000, C has consistently ranked among the top two languages in the TIOBE index, a measure of the popularity of programming languages.[10]",
            "C++ (/ˌsiːˌplʌsˈplʌs/) is a general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language, or \"C with Classes\". The language has expanded significantly over time, and modern C++ now has object-oriented, generic, and functional features in addition to facilities for low-level memory manipulation. It is almost always implemented as a compiled language, and many vendors provide C++ compilers, including the Free Software Foundation, LLVM, Microsoft, Intel, Oracle, and IBM, so it is available on many platforms.[9]\n" +
                    "\n" +
                    "C++ was designed with an orientation toward system programming and embedded, resource-constrained software and large systems, with performance, efficiency, and flexibility of use as its design highlights.[10] C++ has also been found useful in many other contexts, with key strengths being software infrastructure and resource-constrained applications,[10] including desktop applications, video games, servers (e.g. e-commerce, web search, or databases), and performance-critical applications (e.g. telephone switches or space probes).[11]\n" +
                    "\n" +
                    "C++ is standardized by the International Organization for Standardization (ISO), with the latest standard version ratified and published by ISO in December 2020 as ISO/IEC 14882:2020 (informally known as C++20).[12] The C++ programming language was initially standardized in 1998 as ISO/IEC 14882:1998, which was then amended by the C++03, C++11, C++14, and C++17 standards. The current C++20 standard supersedes these with new features and an enlarged standard library. Before the initial standardization in 1998, C++ was developed by Danish computer scientist Bjarne Stroustrup at Bell Labs since 1979 as an extension of the C language; he wanted an efficient and flexible language similar to C that also provided high-level features for program organization.[13] Since 2012, C++ has been on a three-year release schedule[14] with C++23 as the next planned standard.[15]",
            "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let programmers write once, run anywhere (WORA),[17] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.[18] Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture. The syntax of Java is similar to C and C++, but has fewer low-level facilities than either of them. The Java runtime provides dynamic capabilities (such as reflection and runtime code modification) that are typically not available in traditional compiled languages. As of 2019, Java was one of the most popular programming languages in use according to GitHub,[19][20] particularly for client–server web applications, with a reported 9 million developers.[21]\n" +
                    "\n" +
                    "Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle) and released in 1995 as a core component of Sun Microsystems' Java platform. The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licenses. As of May 2007, in compliance with the specifications of the Java Community Process, Sun had relicensed most of its Java technologies under the GPL-2.0-only license. Oracle offers its own HotSpot Java Virtual Machine, however the official reference implementation is the OpenJDK JVM which is free open-source software and used by most developers and is the default JVM for almost all Linux distributions.\n" +
                    "\n" +
                    "As of October 2021, Java 17 is the latest version. Java 8, 11 and 17 are the current long-term support (LTS) versions. Oracle released the last zero-cost public update for the legacy version Java 8 LTS in January 2019 for commercial use, although it will otherwise still support Java 8 with public updates for personal use indefinitely. Other vendors have begun to offer zero-cost builds of OpenJDK 8 and 11 that are still receiving security and other upgrades.\n" +
                    "\n" +
                    "Oracle (and others) highly recommend uninstalling outdated and unsupported versions of Java, because of serious risks due to unresolved security issues.[22] Oracle advises its users to immediately transition to a supported version, such as one of the LTS versions (8, 11, 17).",
            "Kotlin (/ˈkɒtlɪn/)[2] is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library,[3] but type inference allows its syntax to be more concise. Kotlin mainly targets the JVM, but also compiles to JavaScript (e.g., for frontend web applications using React[4]) or native code (via LLVM); e.g., for native iOS apps sharing business logic with Android apps.[5] Language development costs are borne by JetBrains, while the Kotlin Foundation protects the Kotlin trademark.[6]\n" +
                    "\n" +
                    "On 7 May 2019, Google announced that the Kotlin programming language is now its preferred language for Android app developers.[7] Since the release of Android Studio 3.0 in October 2017, Kotlin has been included as an alternative to the standard Java compiler. The Android Kotlin compiler produces Java 8 bytecode by default (which runs in any later JVM), but lets the programmer choose to target Java 9 up to 16, for optimization,[8] or allows for more features; has bidirectional record class interoperability support for JVM, introduced in Java 16, considered stable as of Kotlin 1.5.\n" +
                    "\n" +
                    "Kotlin support for compilation directly to JavaScript (i.e., the classic back-end) is considered stable since Kotlin 1.3 by its developers, while the new Kotlin/JS(IR) is in beta as of version 1.5.30. The new optimized implementations of Kotlin/JVM(IR) and Kotlin/JS (IR-based) were introduced in version 1.4. Kotlin/JVM(IR) is considered stable as of the version 1.5 release. Kotlin/Native (for e.g. Apple silicon support) has been considered beta since version 1.3.[9][10]",
            "Ruby is an interpreted, high-level, general-purpose programming language. It was designed and developed in the mid-1990s by Yukihiro \"Matz\" Matsumoto in Japan.\n" +
                    "\n" +
                    "Ruby is dynamically typed and uses garbage collection and just-in-time compilation. It supports multiple programming paradigms, including procedural, object-oriented, and functional programming. According to the creator, Ruby was influenced by Perl, Smalltalk, Eiffel, Ada, BASIC, and Lisp.[11][3]",
            "Python is an interpreted high-level general-purpose programming language. Its design philosophy emphasizes code readability with its use of significant indentation. Its language constructs as well as its object-oriented approach aim to help programmers write clear, logical code for small and large-scale projects.[31]\n" +
                    "\n" +
                    "Python is dynamically-typed and garbage-collected. It supports multiple programming paradigms, including structured (particularly, procedural), object-oriented and functional programming. It is often described as a \"batteries included\" language due to its comprehensive standard library.[32]\n" +
                    "\n" +
                    "Guido van Rossum began working on Python in the late 1980s, as a successor to the ABC programming language, and first released it in 1991 as Python 0.9.0.[33] Python 2.0 was released in 2000 and introduced new features, such as list comprehensions and a cycle-detecting garbage collection system (in addition to reference counting). Python 3.0 was released in 2008 and was a major revision of the language that is not completely backward-compatible. Python 2 was discontinued with version 2.7.18 in 2020.[34]\n" +
                    "\n" +
                    "Python consistently ranks as one of the most popular programming languages.[35][36][37][38]",
            "JavaScript (/ˈdʒɑːvəˌskrɪpt/),[10] often abbreviated as JS, is a programming language that conforms to the ECMAScript specification.[11] JavaScript is high-level, often just-in-time compiled and multi-paradigm. It has dynamic typing, prototype-based object-orientation and first-class functions.\n" +
                    "\n" +
                    "Alongside HTML and CSS, JavaScript is one of the core technologies of the World Wide Web.[12] Over 97% of websites use it client-side for web page behavior,[13] often incorporating third-party libraries.[14] All major web browsers have a dedicated JavaScript engine to execute the code on the user's device.\n" +
                    "\n" +
                    "As a multi-paradigm language, JavaScript supports event-driven, functional, and imperative programming styles. It has application programming interfaces (APIs) for working with text, dates, regular expressions, standard data structures, and the Document Object Model (DOM).\n" +
                    "\n" +
                    "The ECMAScript standard does not include any input/output (I/O), such as networking, storage, or graphics facilities. In practice, the web browser or other runtime system provides JavaScript APIs for I/O.\n" +
                    "\n" +
                    "JavaScript engines were originally used only in web browsers, but they are now core components of some servers and a variety of applications. The most popular runtime system for this usage is Node.js.\n" +
                    "\n" +
                    "Although there are similarities between JavaScript and Java, including language name, syntax, and respective standard libraries, the two languages are distinct and differ greatly in design.",
            "The .NET Framework (pronounced as \"dot net\") is a software framework developed by Microsoft that runs primarily on Microsoft Windows. It includes a large class library called Framework Class Library (FCL) and provides language interoperability (each language can use code written in other languages) across several programming languages. Programs written for .NET Framework execute in a software environment (in contrast to a hardware environment) named the Common Language Runtime (CLR). The CLR is an application virtual machine that provides services such as security, memory management, and exception handling. As such, computer code written using .NET Framework is called \"managed code\". FCL and CLR together constitute the .NET Framework.\n" +
                    "\n" +
                    "FCL provides the user interface, data access, database connectivity, cryptography, web application development, numeric algorithms, and network communications. Programmers produce software by combining their source code with .NET Framework and other libraries. The framework is intended to be used by most new applications created for the Windows platform. Microsoft also produces an integrated development environment for .NET software called Visual Studio.\n" +
                    "\n" +
                    ".NET Framework began as proprietary software, although the firm worked to standardize the software stack almost immediately, even before its first release. Despite the standardization efforts, developers, mainly those in the free and open-source software communities, expressed their unease with the selected terms and the prospects of any free and open-source implementation, especially regarding software patents. Since then, Microsoft has changed .NET development to more closely follow a contemporary model of a community-developed software project, including issuing an update to its patent promising to address the concerns.[2]\n" +
                    "\n" +
                    "In April 2019, Microsoft released .NET Framework 4.8, the last version of the framework as a proprietary offering. Only monthly security and reliability bug fixes to that version have been released since then. No further changes to that version are planned.[3",
            "Perl is a family of two high-level, general-purpose, interpreted, dynamic programming languages. \"Perl\" refers to Perl 5, but from 2000 to 2019 it also referred to its redesigned \"sister language\", Perl 6, before the latter's name was officially changed to Raku in October 2019.[9][10]\n" +
                    "\n" +
                    "Though Perl is not officially an acronym,[11] there are various backronyms in use, including \"Practical Extraction and Reporting Language\".[12] Perl was developed by Larry Wall in 1987 as a general-purpose Unix scripting language to make report processing easier.[13] Since then, it has undergone many changes and revisions. Raku, which began as a redesign of Perl 5 in 2000, eventually evolved into a separate language. Both languages continue to be developed independently by different development teams and liberally borrow ideas from each other.\n" +
                    "\n" +
                    "The Perl languages borrow features from other programming languages including C, shell script (sh), AWK, and sed;[14] They provide text processing facilities without the arbitrary data-length limits of many contemporary Unix command line tools.[15] Perl 5 gained widespread popularity in the late 1990s as a CGI scripting language, in part due to its unsurpassed regular expression and string parsing abilities.[16][17][18][19]\n" +
                    "\n" +
                    "In addition to CGI, Perl 5 is used for system administration, network programming, finance, bioinformatics, and other applications, such as for GUIs. It has been nicknamed \"the Swiss Army chainsaw of scripting languages\" because of its flexibility and power,[20] and also its ugliness.[21] In 1998, it was also referred to as the \"duct tape that holds the Internet together,\" in reference to both its ubiquitous use as a glue language and its perceived inelegance.[22]\n" +
                    "\n" +
                    "Perl is a highly expressive programming language: source code for a given algorithm can be short and highly compressible.[23][24]",
            "PHP is a general-purpose scripting language geared towards web development.[7] It was originally created by Danish-Canadian programmer Rasmus Lerdorf in 1994.[8] The PHP reference implementation is now produced by The PHP Group.[9] PHP originally stood for Personal Home Page,[8] but it now stands for the recursive initialism PHP: Hypertext Preprocessor.[10]\n" +
                    "\n" +
                    "PHP code is usually processed on a web server by a PHP interpreter implemented as a module, a daemon or as a Common Gateway Interface (CGI) executable. On a web server, the result of the interpreted and executed PHP code – which may be any type of data, such as generated HTML or binary image data – would form the whole or part of an HTTP response. Various web template systems, web content management systems, and web frameworks exist which can be employed to orchestrate or facilitate the generation of that response. Additionally, PHP can be used for many programming tasks outside the web context, such as standalone graphical applications[11] and robotic drone control.[12] PHP code can also be directly executed from the command line.\n" +
                    "\n" +
                    "The standard PHP interpreter, powered by the Zend Engine, is free software released under the PHP License. PHP has been widely ported and can be deployed on most web servers on a variety of operating systems and platforms.[13]\n" +
                    "\n" +
                    "The PHP language evolved without a written formal specification or standard until 2014, with the original implementation acting as the de facto standard which other implementations aimed to follow. Since 2014, work has gone on to create a formal PHP specification.[14]\n" +
                    "\n" +
                    "W3Techs reports that, as of April 2021, \"PHP is used by 79.2% of all the websites whose server-side programming language we know.\"[15] PHP version 7.4 is the most used versions, then 7.3 which goes out of support on 6 December 2021.",
            "Ajax (also AJAX /ˈeɪdʒæks/; short for \"Asynchronous JavaScript and XML\")[1][2] is a set of web development techniques that uses various web technologies on the client-side to create asynchronous web applications. With Ajax, web applications can send and retrieve data from a server asynchronously (in the background) without interfering with the display and behaviour of the existing page. By decoupling the data interchange layer from the presentation layer, Ajax allows web pages and, by extension, web applications, to change content dynamically without the need to reload the entire page.[3] In practice, modern implementations commonly utilize JSON instead of XML.\n" +
                    "\n" +
                    "Ajax is not a technology, but rather a programming concept. HTML and CSS can be used in combination to mark up and style information. The webpage can be modified by JavaScript to dynamically display—and allow the user to interact with the new information. The built-in XMLHttpRequest object is used to execute Ajax on webpages, allowing websites to load content onto the screen without refreshing the page. Ajax is not a new technology, nor is it a new language. Instead, it is existing technologies used in a new way.",
            "Go is a statically typed, compiled programming language designed at Google[10] by Robert Griesemer, Rob Pike, and Ken Thompson.[11] Go is syntactically similar to C, but with memory safety, garbage collection, structural typing,[5] and CSP-style concurrency.[12] The language is often referred to as Golang because of its former domain name, golang.org, but the proper name is Go.[13]\n" +
                    "\n" +
                    "There are two major implementations:\n" +
                    "\n" +
                    "Google's self-hosting[14] \"gc\" compiler toolchain targeting multiple operating systems, and WebAssembly.[15]\n" +
                    "gofrontend, a frontend to other compilers, with the libgo library. With GCC the combination is gccgo;[16] with LLVM the combination is gollvm.[17][a]\n" +
                    "A third-party source-to-source compiler, GopherJS,[19] compiles Go to JavaScript for front-end web development."
        )
//        val contentDescs = arrayOf<String>(
//            "bahasa C adalah................",
//            "bahasa C++ adalah................",
//            "bahasa Java adalah................",
//            "bahasa Kotlin adalah................",
//            "bahasa Ruby adalah................",
//            "bahasa Phyton adalah................",
//            "bahasa javascript adalah................",
//            "bahasa Net adalah................",
//            "bahasa Perl adalah................",
//            "bahasa PHP adalah................",
//            "bahasa Ajax adalah................",
//            "bahasa Golang adalah................"
//        )

        val myListAdapter = CustomList(this, thumbnailPaths, number, title, desc)
        val listView = findViewById<View>(R.id.list_view) as ListView
        listView.adapter = myListAdapter

        // onitemclick
        listView.setOnItemClickListener(){
                adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
//            Toast.makeText(this, "Anda memilih : $itemAtPos atau $itemIdAtPos, POS[$position]", Toast.LENGTH_LONG).show()

            val contentIntent = Intent(this, ContentActivity::class.java)
            contentIntent.putExtra("title", title[position])
            contentIntent.putExtra("thumbnail", thumbnailPaths[position])
            contentIntent.putExtra("desc", contentDescs[position])
            startActivity(contentIntent)
        }
    }
}