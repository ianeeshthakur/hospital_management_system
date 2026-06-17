 async function admitPatient() {

        // 1. Form se values uthao
        const name = document.getElementById("name").value;
        const email = document.getElementById("email").value;
        const birthdate = document.getElementById("birthdate").value;
        const gender = document.getElementById("gender").value;

        // 2. Validation
        if (!name || !email || !birthdate || !gender) {
            showMessage("Saare fields fill karo!", "error");
            return;
        }

        // 3. JSON object banao
        const patientData = {
            name: name,
            email: email,
            birthdate: birthdate,
            gender: gender
        };

        // 4. Backend API call
        try {
            const response = await fetch("http://localhost:8080/patients/admit", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(patientData)
            });

            const data = await response.json();

            // 5. Response ke hisaab se message dikhao
            if (response.status === 201) {
                showMessage(
                    `✅ Patient admitted! Name: ${data.name}, Bed No: ${data.bedNo}`,
                    "success"
                );
            } else {
                showMessage("❌ Kuch galat hua!", "error");
            }

        } catch (error) {
            showMessage("❌ Server se connect nahi ho pa raha!", "error");
        }
    }

    function showMessage(text, type) {
        const msg = document.getElementById("message");
        msg.style.display = "block";
        msg.className = type;
        msg.innerHTML = text;
    }