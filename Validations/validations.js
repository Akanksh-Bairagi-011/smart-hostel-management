$(document).ready(function () {

    // ✅ Room Preference Form Validation
    $('#roomPreferenceForm').submit(function (e) {
      const type = $('#roomType').val();
      const beds = $('#bedCount').val();
      const floor = $('#preferredFloor').val();
  
      if (!type || !beds || !floor) {
        alert('Please fill all room preference fields.');
        e.preventDefault();
      }
    });
  
    // ✅ Visitor Form Validation
   
    // ✅ Real-time input restriction and validation for phone number
$('#visitorPhone').on('input', function () {
    // Allow only digits
    this.value = this.value.replace(/[^0-9]/g, '');
  
    // Limit to 10 digits
    if (this.value.length > 10) {
      this.value = this.value.slice(0, 10);
    }
  
    const phone = this.value;
    const phoneRegex = /^[6-9][0-9]{9}$/;
  
    if (!phoneRegex.test(phone)) {
      $('#phoneError').text('Enter valid 10-digit number starting with 6–9.');
    } else {
      $('#phoneError').text('');
    }
  });

      // ✅ Visitor Form Validation on Submit
$('#visitorForm').submit(function (e) {
    const name = $('#visitorName').val().trim();
    const relation = $('#visitorRelation').val().trim();
    const phone = $('#visitorPhone').val().trim();
    const phoneRegex = /^[6-9][0-9]{9}$/;
  
    let isValid = true;
  
    if (!name || !relation || !phone) {
      alert('All visitor fields are required.');
      isValid = false;
    } else if (!phoneRegex.test(phone)) {
      $('#phoneError').text('Enter valid 10-digit number starting with 6–9.');
      isValid = false;
    } else {
      $('#phoneError').text('');
    }
  
    if (!isValid) e.preventDefault();
  });
  
  
  
    // ✅ Complaint Form Validation
    $('#complaintForm').submit(function (e) {
      const type = $('#complaintType').val();
      const desc = $('#complaintDesc').val().trim();
  
      if (!type || !desc) {
        alert('Please select complaint type and enter description.');
        e.preventDefault();
      } else if (desc.length < 10) {
        alert('Description must be at least 10 characters.');
        e.preventDefault();
      }
    });
  });
  