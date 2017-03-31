package com.softgroup.common.model.mapper;

import com.softgroup.common.model.mapper.api.ModelMapper;
import com.softgroup.common.model.mapper.impl.ModelMapperImpl;
import com.softgroup.common.model.mapper.models.TestAddress;
import com.softgroup.common.model.mapper.models.TestPerson;
import com.softgroup.common.model.mapper.models.TestPersonDTO;
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

    private TestPersonDTO personDTO;

    private TestPerson fullPerson;
    private TestPerson personWithNullValues;

    @Before
    public void init(){
        TestAddress address = new TestAddress("Chicago","Galagers 43", "USA" );
        fullPerson = new TestPerson("Bob", "Fisher", 34, address);
        personWithNullValues = new TestPerson("John", null, 24, null);
    }

    @Test
    public void fromFullPersonToPersonDTOmapMethodTest(){
        personDTO = modelMapper.map(fullPerson, TestPersonDTO.class);

        assertThat(personDTO, notNullValue());
        assertThat(personDTO.getName(), is(fullPerson.getName()));
        assertThat(personDTO.getLastName(), is(fullPerson.getLastName()));
        assertThat(personDTO.getAge(), is(fullPerson.getAge()));
        assertThat(personDTO.getCity(), is(fullPerson.getAddress().getCity()));
        assertThat(personDTO.getStreet(), is(fullPerson.getAddress().getStreet()));
        assertThat(personDTO.getCountry(), is(fullPerson.getAddress().getCountry()));

    }

    @Test
    public void fromPersonDTOtoAddressMapMethodTest(){
        personDTO = modelMapper.map(fullPerson, TestPersonDTO.class);

        TestAddress mappedAddress = modelMapper.map(personDTO, TestAddress.class);

        assertThat(mappedAddress, notNullValue());
        assertThat(mappedAddress.getCity(), is(personDTO.getCity()));
        assertThat(mappedAddress.getStreet(), is(personDTO.getStreet()));
        assertThat(mappedAddress.getCountry(), is(personDTO.getCountry()));

    }

    @Test
    public void fromPersonDTOtoPersonMapMethodTest(){
        personDTO = modelMapper.map(fullPerson, TestPersonDTO.class);

        TestPerson mappedPerson = modelMapper.map(personDTO,TestPerson.class);

        assertThat(mappedPerson, notNullValue());
        assertThat(mappedPerson.getName(), is(personDTO.getName()));
        assertThat(mappedPerson.getLastName(), is(personDTO.getLastName()));
        assertThat(mappedPerson.getAge(), is(personDTO.getAge()));
        assertThat(mappedPerson.getAddress().getCity(), is(personDTO.getCity()));
        assertThat(mappedPerson.getAddress().getStreet(), is(personDTO.getStreet()));
        assertThat(mappedPerson.getAddress().getCountry(), is(personDTO.getCountry()));
    }


    @Test
    public void fromPersonWithNullValuesToPersonDTOmapMethodTest(){
        personDTO = modelMapper.map(personWithNullValues, TestPersonDTO.class);

        assertThat(personDTO, notNullValue());
        assertThat(personDTO.getName(), is(personWithNullValues.getName()));
        assertThat(personDTO.getLastName(), is(personWithNullValues.getLastName()));
        assertThat(personDTO.getAge(), is(personWithNullValues.getAge()));
        assertThat(personDTO.getCity(),  nullValue());
        assertThat(personDTO.getStreet(), nullValue());
        assertThat(personDTO.getCountry(), nullValue());

    }

    @Test
    public void fromPersonDTOWithNullValuesToAddressMapMethodTest(){
        personDTO = modelMapper.map(personWithNullValues, TestPersonDTO.class);

        TestAddress mappedAddress = modelMapper.map(personDTO, TestAddress.class);

        assertThat(mappedAddress, notNullValue());
        assertThat(mappedAddress.getCity(), nullValue());
        assertThat(mappedAddress.getStreet(), nullValue());
        assertThat(mappedAddress.getCountry(), nullValue());
    }

    @Test
    public void fromPersonDTOWithNullValuesToPersonMapMethodTest(){
        personDTO = modelMapper.map(personWithNullValues, TestPersonDTO.class);

        TestPerson mappedPerson = modelMapper.map(personDTO,TestPerson.class);

        assertThat(mappedPerson, notNullValue());
        assertThat(mappedPerson.getName(), is(personDTO.getName()));
        assertThat(mappedPerson.getLastName(), nullValue());
        assertThat(mappedPerson.getAge(), is(personDTO.getAge()));
        assertThat(mappedPerson.getAddress(), nullValue());
    }


    @Test(expected = IllegalArgumentException.class)
    public void mapMethodWithSourceWrongArgumentTest(){
        TestPerson person = modelMapper.map(null, TestPerson.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mapMethodWithDestinationWrongArgumentTest(){
        TestPersonDTO personDTO = modelMapper.map(fullPerson, null);
    }

}
