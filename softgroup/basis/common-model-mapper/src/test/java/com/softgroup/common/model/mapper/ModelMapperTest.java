package com.softgroup.common.model.mapper;

import com.softgroup.common.model.mapper.api.ModelMapper;
import com.softgroup.common.model.mapper.impl.ModelMapperImpl;
import com.softgroup.common.model.mapper.models.Address;
import com.softgroup.common.model.mapper.models.Person;
import com.softgroup.common.model.mapper.models.PersonDTO;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author AlexKazmirchuk
 * @since 31.03.17.
 */

public class ModelMapperTest {

    private ModelMapper modelMapper = new ModelMapperImpl();

    private PersonDTO personDTO;

    private Person person1;
    private Person person2;

    @Before
    public void init(){
        Address address = new Address("Chicago","Galagers 43", "USA" );
        person1 = new Person("Bob", "Fisher", 34, address);
        person2 = new Person("John", null, 24, null);
    }

    @Test
    public void fromPerson1ToPersonDTOmapMethodTest(){
        personDTO = modelMapper.map(person1, PersonDTO.class);

        assertThat(personDTO, notNullValue());
        assertThat(personDTO.getName(), is(person1.getName()));
        assertThat(personDTO.getLastName(), is(person1.getLastName()));
        assertThat(personDTO.getAge(), is(person1.getAge()));
        assertThat(personDTO.getCity(), is(person1.getAddress().getCity()));
        assertThat(personDTO.getStreet(), is(person1.getAddress().getStreet()));
        assertThat(personDTO.getCountry(), is(person1.getAddress().getCountry()));

        Address mappedAddress = modelMapper.map(personDTO, Address.class);

        assertThat(mappedAddress, notNullValue());
        assertThat(mappedAddress.getCity(), is(personDTO.getCity()));
        assertThat(mappedAddress.getStreet(), is(personDTO.getStreet()));
        assertThat(mappedAddress.getCountry(), is(personDTO.getCountry()));

        Person mappedPerson = modelMapper.map(personDTO,Person.class);

        assertThat(mappedPerson, notNullValue());
        assertThat(mappedPerson.getName(), is(personDTO.getName()));
        assertThat(mappedPerson.getLastName(), is(personDTO.getLastName()));
        assertThat(mappedPerson.getAge(), is(personDTO.getAge()));
        assertThat(mappedPerson.getAddress().getCity(), is(personDTO.getCity()));
        assertThat(mappedPerson.getAddress().getStreet(), is(personDTO.getStreet()));
        assertThat(mappedPerson.getAddress().getCountry(), is(personDTO.getCountry()));
    }

    @Test
    public void fromPerson2ToPersonDTOmapMethodTest(){
        personDTO = modelMapper.map(person2, PersonDTO.class);

        assertThat(personDTO, notNullValue());
        assertThat(personDTO.getName(), is(person2.getName()));
        assertThat(personDTO.getLastName(), is(person2.getLastName()));
        assertThat(personDTO.getAge(), is(person2.getAge()));
        assertThat(personDTO.getCity(),  nullValue());
        assertThat(personDTO.getStreet(), nullValue());
        assertThat(personDTO.getCountry(), nullValue());

        Address mappedAddress = modelMapper.map(personDTO, Address.class);

        assertThat(mappedAddress, notNullValue());
        assertThat(mappedAddress.getCity(), nullValue());
        assertThat(mappedAddress.getStreet(), nullValue());
        assertThat(mappedAddress.getCountry(), nullValue());

        Person mappedPerson = modelMapper.map(personDTO,Person.class);

        assertThat(mappedPerson, notNullValue());
        assertThat(mappedPerson.getName(), is(personDTO.getName()));
        assertThat(mappedPerson.getLastName(), nullValue());
        assertThat(mappedPerson.getAge(), is(personDTO.getAge()));
        assertThat(mappedPerson.getAddress(), nullValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mapWithWrongArgumentsTest1(){
        Person person = modelMapper.map(null, Person.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mapWithWrongArgumentsTest2(){
        PersonDTO personDTO = modelMapper.map(person1, null);
    }

}
