document.addEventListener("DOMContentLoaded", function () {
    const linkColor = document.querySelectorAll(".nav_link");

    function colorLink() {
        if (linkColor) {
            linkColor.forEach((l) => l.classList.remove("active"));
            this.classList.add("active");

            // Extract section ID from href attribute and show the corresponding section
            const sectionId = this.getAttribute("href").substring(1);
            showSection(sectionId);
        }
    }

    linkColor.forEach((l) => l.addEventListener("click", colorLink));

    function showSection(sectionId) {
        const sections = document.querySelectorAll(".section");
        sections.forEach((section) => {
            section.classList.remove("active-section");
        });

        const activeSection = document.getElementById(sectionId);
        if (activeSection) {
            activeSection.classList.add("active-section");
        }
    }

    const showNavbar = (toggleId, navId, bodyId, headerId) => {
        const toggle = document.getElementById(toggleId),
            nav = document.getElementById(navId),
            bodypd = document.getElementById(bodyId),
            headerpd = document.getElementById(headerId);

        // Validate that all variables exist
        if (toggle && nav && bodypd && headerpd) {
            toggle.addEventListener("click", () => {
                // show navbar
                nav.classList.toggle("show");
                // change icon
                toggle.classList.toggle("bx-x");
                // add padding to body
                bodypd.classList.toggle("body-pd");
                // add padding to header
                headerpd.classList.toggle("body-pd");
            });
        }
    };

    showNavbar("header-toggle", "nav-bar", "body-pd", "header");
});
