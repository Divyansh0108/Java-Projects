import java.util.*;
class Patient {
    private String name;
    private int age;
    private String contactNumber;

    public Patient(String name, int age, String contactNumber)
    {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }
}

class Doctor{
    private String name;
    private String specialization;

    public Doctor(String name, String specialization)
    {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName()
    {
        return name;
    }

    public String getSpecialization()
    {
        return specialization;
    }
}

class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;

    public Appointment(Doctor doctor, Patient patient, String date)
    {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public String getDate()
    {
        return date;
    }
}

class Hospital{
    private String name;
    private List<Appointment> appointments;
    private Map<String, Doctor> doctors;

    public Hospital(String name)
    {
        this.name = name;
        this.doctors = new HashMap<>();
        this.appointments = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addDoctor(Doctor doctor)
    {
        doctors.put(doctor.getName(), doctor);
    }

    public Doctor getDoctor(String doctorName)
    {
        return doctors.get(doctorName);
    }

    public void bookAppointment(Doctor doctor, Patient patient, String date)
    {
        Appointment app = new Appointment(doctor, patient, date);
        appointments.add(app);
    }
    public List<Appointment> getAppointments(Doctor doctor)
    {
        List<Appointment> doctorAppointments = new ArrayList<>();
        for(Appointment appointment : appointments)
        {
            if(appointment.getDoctor().equals(doctor))
            {
                doctorAppointments.add(appointment);
            }
        }
        return doctorAppointments;
    }

    public class AppointmentSystemEnvironment{
        public static void main(String[] args) {
            Hospital hospital = new Hospital("My Hospital");

            Doctor doctor1 = new Doctor("Dr. Stephen Strange", "Time Manipulation");
            Doctor doctor2 = new Doctor("Dr. Bruce Banner", "Anger management");
            Doctor doctor3 = new Doctor("Dr. Tony Stark", "Doesn't need an intro lol");

            hospital.addDoctor(doctor1);
            hospital.addDoctor(doctor2);
            hospital.addDoctor(doctor3);

            Scanner marvel = new Scanner(System.in);

            while(true)
            {
                System.out.println("---- Welcome to Hospital Appointment Gateway ----");
                System.out.println("1. Want to book an appointment?");
                System.out.println("2. Want to view your appointments? [FOR STAFF ONLY]");
                System.out.println("3. Exit the system");
                System.out.println("---------------------------------------------------");

                int choice = marvel.nextInt();
                marvel.nextLine();

                switch(choice)
                {
                    case 1:
                    System.out.println("Please enter your good name: ");
                    String patientName = marvel.nextLine();
                    System.out.println("Please enter your age: ");
                    int patientAge = marvel.nextInt();
                    marvel.nextLine();
                    System.out.println("Please enter your contact number with country code: ");
                    String patientContactNumber = marvel.nextLine();
                    Patient patient = new Patient(patientName, patientAge, patientContactNumber);

                    System.out.println("Please enter the name of the doctor you want to book an appointment with: ");
                    System.out.println("1. " + doctor1.getName()+"[ "+doctor1.getSpecialization()+" ]");
                    System.out.println("2. " + doctor2.getName()+"[ "+doctor2.getSpecialization()+" ]");
                    System.out.println("3. " + doctor3.getName()+"[ "+doctor3.getSpecialization()+" ]");
                    int doctorChoice = marvel.nextInt();
                    marvel.nextLine();
                    Doctor selectedDoctor = (doctorChoice == 1) ? doctor1 : (doctorChoice == 2) ? doctor2 : doctor3;

                    System.out.println("Please enter the date of your expected visit: [in dd-mm-yyyy format only] ");
                    String visitDate = marvel.nextLine();

                    hospital.bookAppointment(selectedDoctor, patient, visitDate);
                    System.out.println("Thanks for the visit! Your appointment has been booked successfully!! Have a good day ahead");
                    System.out.println("---------------------------------------------------");
                    break;

                    case 2:
                    System.out.println("Please enter the name of the doctor you want to view appointments of: ");
                    String doctorName = marvel.nextLine();
                    Doctor doctor = hospital.getDoctor(doctorName);
                    if(doctor!=null)
                    {
                        List<Appointment> doctorAppointments = hospital.getAppointments(doctor);
                        if(doctorAppointments.isEmpty())
                        {
                            System.out.println("No appointments booked for this doctor yet!");
                        }
                        else{
                            System.out.println("The appointments booked for " + doctorName + " are: ");
                            for(Appointment appointment : doctorAppointments)
                            {
                                System.out.println("Patient Name: " + appointment.getPatient().getName());
                                System.out.println("Patient Age: " + appointment.getPatient().getAge());
                                System.out.println("Patient's Contact Number: " + appointment.getPatient().getContactNumber());
                                System.out.println("Scheduled date of visit: " + appointment.getDate());
                                System.out.println("---------------------------------------------------");
                            }
                        }
                    }

                    else{
                        System.out.println("No such doctor exists in our database!");
                    }
                    System.out.println("---------------------------------------------------");
                    break;

                    case 3:
                    System.out.println("Thanks for using our system! Have a good day ahead! Exiting now....");
                    System.exit(0);
                    break;

                    default:
                    System.out.println("Invalid choice! Please try again!");
                    System.out.println("---------------------------------------------------");
                    break;
                }
            }
        }
    }
}