package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.checkup.Checkup;
import seedu.address.model.person.Address;
import seedu.address.model.person.Appointment;
import seedu.address.model.person.BloodType;
import seedu.address.model.person.DateOfBirth;
import seedu.address.model.person.Email;
import seedu.address.model.person.MedicalHistory;
import seedu.address.model.person.Name;
import seedu.address.model.person.NextOfKin;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_DOB = "01/01/2001";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_BLOOD_TYPE = "AB+";
    public static final String DEFAULT_APPOINTMENT = "Patient";
    public static final String DEFAULT_NEXTOFKIN = "";

    private Name name;
    private DateOfBirth dob;
    private Phone phone;
    private Email email;
    private Address address;
    private BloodType bloodType;
    private Appointment appointment;
    private Set<Tag> tags;
    private Set<Checkup> checkups;
    private NextOfKin nextOfKin;
    private Set<MedicalHistory> medicalHistory;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        dob = new DateOfBirth(DEFAULT_DOB);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        bloodType = new BloodType(DEFAULT_BLOOD_TYPE);
        appointment = new Appointment(DEFAULT_APPOINTMENT);
        nextOfKin = new NextOfKin(DEFAULT_NEXTOFKIN);
        tags = new HashSet<>();
        checkups = new HashSet<>();
        medicalHistory = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        dob = personToCopy.getDateOfBirth();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        bloodType = personToCopy.getBloodType();
        appointment = personToCopy.getAppointment();
        nextOfKin = personToCopy.getNextOfKin();
        tags = new HashSet<>(personToCopy.getTags());
        checkups = new HashSet<>(personToCopy.getCheckups());
        medicalHistory = new HashSet<>(personToCopy.getMedicalHistory());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * test
     * @param checkups test
     * @return test
     */
    public PersonBuilder withCheckups(String ... checkups) {
        this.checkups = SampleDataUtil.getCheckupSet(checkups);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code DOB} of the {@code Person} that we are building.
     */
    public PersonBuilder withDateOfBirth(String dob) {
        this.dob = new DateOfBirth(dob);
        return this;
    }
    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code BloodType} of the {@code Person} that we are building.
     */
    public PersonBuilder withBloodType(String bloodType) {
        this.bloodType = new BloodType(bloodType);
        return this;
    }

    /**
     * Sets the {@code Appointment} of the {@code Person} that we are building.
     */
    public PersonBuilder withAppointment(String appointment) {
        this.appointment = new Appointment(appointment);
        return this;
    }

    /**
     * Sets the {@code NextOfKin} of the {@code Person} that we are building.
     * The input should be in the format "Name Phone", e.g., "Jane Doe 91234567".
     */
    public PersonBuilder withNextOfKin(String nok) {
        this.nextOfKin = new NextOfKin(nok);
        return this;
    }

    /**
     * Sets the {@code MedicalHistory} of the {@code Person} that we are building.
     */
    public PersonBuilder withMedicalHistory(String ... medicalHistories) {
        this.medicalHistory = SampleDataUtil.getMedicalHistorySet(medicalHistories);
        return this;
    }

    public Person build() {
        return new Person(name, dob, phone, email, address, bloodType, appointment, tags, nextOfKin, medicalHistory);
    }

}
